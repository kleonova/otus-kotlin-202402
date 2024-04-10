class SqlSelectBuilder {
    private val columns = mutableListOf<String>()
    private var tableName: String? = null
    private val conditions = mutableListOf<String>()

    fun from(table: String) {
        tableName = table
    }

    fun select(vararg columns: String) {
        if (columns.isEmpty()) {
            throw IllegalArgumentException("At least one column should be defined")
        }

        if (this.columns.isNotEmpty()) {
            throw IllegalStateException("Detected an attempt to re-define columns to fetch. " +
                    "Current columns list: ${this.columns}, new columns list: $columns")
        }

        this.columns.addAll(columns)
    }

    fun where(initializer: SqlWhereBuilder.() -> Unit) {
        val whereBuilder = SqlWhereBuilder()
        whereBuilder.initializer()
        conditions.add(whereBuilder.build())
    }

    fun build(): String {
        val selectClause = if (columns.isEmpty()) "select *" else "select ${columns.joinToString(", ")}"
        val fromClause = tableName?.let { " from $it" } ?: throw IllegalStateException("Table name must be specified")
        val whereClause = if (conditions.isEmpty()) "" else " where ${conditions.joinToString(" and ")}"
        return "$selectClause$fromClause$whereClause"
    }
}

class SqlWhereBuilder {
    private val conditions = mutableListOf<String>()

    infix fun String.eq(value: Any?) {
        val op = when (value) {
            null -> "is"
            else -> "="
        }
        conditions.add("$this $op ${value.toSqlString()}")
    }

    infix fun String.nonEq(value: Any?) {
        val op = when (value) {
            null -> "!is"
            else -> "!="
        }
        conditions.add("$this $op ${value.toSqlString()}")
    }

    fun or(initializer: SqlWhereBuilder.() -> Unit) {
        val orBuilder = SqlWhereBuilder()
        orBuilder.initializer()
        conditions.add("(${orBuilder.buildWithOr()})")
    }

    fun build(): String {
        return conditions.joinToString(" and ")
    }

    private fun buildWithOr(): String {
        return conditions.joinToString(" or ")
    }

    private fun Any?.toSqlString() = when (this) {
        is String -> "'$this'"
        is Number -> "$this"
        null -> "null"
        else -> toString()
    }
}

fun query(initializer: SqlSelectBuilder.() -> Unit): SqlSelectBuilder {
    return SqlSelectBuilder().apply(initializer)
}