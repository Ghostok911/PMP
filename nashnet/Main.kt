package nashnet

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    val dev1 = Developer("George", "Aroun", 4750.0, 5)
    val dev2 = Developer("Jean", "Bekishen", 5500.0, 1)
    val designer = Designer("Tiffany", "Volfer", 6500.0, 3, 0.75)

    val manager = Manager("Felix", "Nukled", 3250.0, 2)
    manager.addTeamMember(dev1)
    manager.addTeamMember(dev2)
    manager.addTeamMember(designer)

    val department = Department(mutableListOf(manager))
    department.giveSalary()

}