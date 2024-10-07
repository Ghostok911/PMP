package nashnet

class Manager(
    name: String,
    surname: String,
    baseSalary: Double,
    experience: Int,
    internal val team: MutableList<Employee> = mutableListOf()
) : Employee(name, surname, baseSalary, experience) {

    fun addTeamMember(member: Employee) {
        team.add(member)
    }
    override fun calculateSalary(): Double {
        var countedSalary = super.calculateSalary()
        countedSalary += when {
            team.size > 10 -> 300.0
            team.size > 5 -> 200.0
            else -> 0.0
        }
        // Додаємо 10% якщо більше половини команди - розробники
        val developerCount = team.count { it is Developer }
        return if (developerCount > team.size / 2) {
            countedSalary * 1.1
        } else {
            countedSalary
        }
    }
    fun getTeamMembers(): List<Employee> = team
}