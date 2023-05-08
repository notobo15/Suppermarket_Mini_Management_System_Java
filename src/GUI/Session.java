/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

public class Session {
    private static int id;
    private static String name;
    private static int role;
    private static String role_name;
    public Session(int id,String name,int role)
    {
        Session.id=id;
        Session.name=name;
        Session.role=role;
        
    }
    
    public Session()
    {
      

        
    }
    public int getId()
    {
        return id;
    }
    public String getName()
    {
        return name;
    }
    public int getRole()
    {
        return role;
    }
    public void setId(int id)
    {
        Session.id=id;
    }
    public void setName(String name)
    {
        Session.name=name;
    }
    public void setRole(int role)
    {
        Session.role=role;
    }

    public String getRole_name() {
        return role_name;
    }

    public  void setRole_name(String role_name) {
        Session.role_name = role_name;
    }
    
}
