package nashnet

class Designer(
    name: String,
    surname: String,
    baseSalary: Double,
    experience: Int,
    effCoefficient: Double
) : Employee(name, surname, baseSalary, experience) {

    private val efficiencyCoefficient: Double =
        when {
            effCoefficient < 0 -> 0.0
            effCoefficient > 1 -> 1.0
            else -> effCoefficient
        }

    override fun calculateSalary(): Double {
        return super.calculateSalary() * efficiencyCoefficient
    }
}