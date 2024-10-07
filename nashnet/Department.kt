package nashnet

class Department(
    private val managers: MutableList<Manager>
) {

    fun giveSalary() {
        managers.forEach { manager ->
            println("${manager.name} ${manager.surname} received ${kotlin.math.round(manager.calculateSalary()).toInt()} shekels.")
            manager.team.forEach {member ->
                println("${member.name} ${member.surname} received ${kotlin.math.round(member.calculateSalary()).toInt()} shekels.")
            }
        }
    }
}