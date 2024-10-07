package nashnet

open class Employee (
    val name: String,
    val surname: String,
    private val baseSalary: Double,
    private val experience: Int
)
{
    open fun calculateSalary(): Double = when {
        experience > 5 -> baseSalary * 1.2 + 500
        experience > 2 -> baseSalary + 200
        else -> baseSalary
    }
}