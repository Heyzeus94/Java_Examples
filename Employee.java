public class Employee {
    //naming instance fields

    private String name;
    private int idNumber;
    private String department;
    private String position;
    private int salary;

    //set instance mutators methods - no static
    public void setName( String listName )
    {
        name = listName;
    }
    public void setIdNumber( int listIdNumber )
    {
        idNumber = listIdNumber;
    }
    public void setIdNumber( String listIdNumber )
    {
        idNumber = Integer.parseInt(listIdNumber);
    }
    public void setDepartment( String listDepartment)
    {
        department = listDepartment;
    }
    public void setPosition( String listPosition)
    {
        position = listPosition;
    }
    public void setSalary( int listSalary)
    {
        salary = listSalary;
    }

    //set accessors
    public String getName()
    {
        return name;
    }
    public String getDepartment()
    {
        return department;
    }
    public int getIdNumber()
    {
        return idNumber;
    }
    public String getPosition ()
    {
        return position;
    }
    public double getSalary ()
    {
        return salary;
    }
    //constructors
    public Employee( String emplName, int emplIdNumber, String emplDepartment, String
            emplPosition, int empSalary )
    {
        name = emplName;
        idNumber = emplIdNumber;
        department = emplDepartment;
        position = emplPosition;
        salary =  empSalary;
    }
    public Employee()
    {
        name = "";
        idNumber = 0;
        department = "";
        position = "";
        salary = 0;
    }
    @Override
    public String toString(){
        StringBuffer output = new StringBuffer()
                .append(System.lineSeparator()).append("Name: ").append(name)
                .append(System.lineSeparator()).append("Id: ").append(idNumber)
                .append(System.lineSeparator()).append("Department: ").append(department)
                .append(System.lineSeparator()).append("Position: ").append(position)
                .append(System.lineSeparator()).append("Salary: ").append(salary);
        return String.valueOf(output);

    }
    public static void main(String[] args)
    {
}}

