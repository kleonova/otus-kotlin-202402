@Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")
actual class UserService {
    actual fun serve(user: User): String = "JVM Service for User $user"
}
