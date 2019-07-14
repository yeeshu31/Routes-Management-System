package DBMS_Project;


import java.sql.*;
import java.util.*;


public class JDBCUsage {

  

   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  

   static final String DB_URL = "jdbc:mysql://localhost:3306/busroutes";



   static final String USER = "root";

   static final String PASS = "31&yashasvi@012000";

   

   public static void main(String[] args) {

   Connection conn = null;

   Statement stmt = null;

   

  //Connecting to database

      


      System.out.println();
      System.out.println("Connecting to database...");

      
      ResultSet rs = null;
      

      Scanner sc=new Scanner(System.in);
      int ch;
      while(true)
      {
    	  System.out.println();
    	  System.out.println();
          System.out.println("1. Add a driver to a bus");
          System.out.println("2. Add an assistant to a bus");
          System.out.println("3. Add a bus");
          System.out.println("4. Add a route");
          System.out.println("5. Add a bus stop");
          System.out.println("6. Add a stop to a route");
          System.out.println("7. Update a bus service schedule");
          System.out.println("8. Find employee ids and their names working for a bus ");
          System.out.println("9. Find buses running between two bus stops on a day");
          System.out.println("10.Find possible routes between two bus stops");
          System.out.println("11.View all routes");
          System.out.println("12.View all bus stops");
          System.out.println("13.View all buses ");
          System.out.println("20.Quit");
          System.out.print("Enter Your Choice : ");
          ch=sc.nextInt();
          switch(ch)
          {
              case 1:
                       System.out.println("Enter emp_id: ");
                       int a1= sc.nextInt();
                       System.out.println("Enter name: ");
                       String a2= sc.next();
                       System.out.println("Enter dob in yyyy-mm-dd format: ");
                       String a3= sc.next();
                       System.out.println("Enter license number: ");
                       int a4= sc.nextInt();
                       System.out.println("Enter reg number of bus he is assigned: ");
                       int a5= sc.nextInt();
                       System.out.println("Enter week day(s) he works: ");
                       String a6= sc.next();
                       
                       try {
                    	   
                    	   conn = DriverManager.getConnection(DB_URL, USER, PASS);
                    	   try {
							Class.forName("com.mysql.cj.jdbc.Driver");
						} catch (ClassNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
                       String sql = "INSERT INTO driver_works_for(emp_id, name, dob, license_num, reg_no, day) "
                               + "VALUES(?,?,?,?,?,?)";
                       PreparedStatement pstmt = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
                       pstmt.setInt(1, a1);
                       pstmt.setString(2, a2);
                       pstmt.setString(3, a3);
                       pstmt.setInt(4, a4);
                       pstmt.setInt(5, a5);
                       pstmt.setString(6, a6);
            
                       
                       int rowAffected = pstmt.executeUpdate();
                       if(rowAffected == 1)
                       {
                           
                           rs = pstmt.getGeneratedKeys();
                           
            
                       }
                       
                       }catch (SQLException ex) {
                           System.out.println(ex.getMessage());
                       } finally {
                           try {
                               if(rs != null)  rs.close();
                           } catch (SQLException e) {
                               System.out.println(e.getMessage());
                           }
                       }
                       
                       break;    
              case 3:  
            	  System.out.println("Enter reg_no: ");
                  int c1= sc.nextInt();
                  System.out.println("Enter route_id: ");
                  int c2= sc.nextInt();
                  System.out.println("Enter capacity of the bus: ");
                  int c3= sc.nextInt();
                
             
                  System.out.println("Enter bus model: ");
                  String c4= sc.next();
                  System.out.println("Enter features of the bus from the set('ac','non ac','music system','video coach','deluxe','sleeper','slidable chairs'): ");
                  String c5= sc.next();
                  
                  
                  
                  try {
               	   
               	   conn = DriverManager.getConnection(DB_URL, USER, PASS);
               	   try {
						Class.forName("com.mysql.cj.jdbc.Driver");
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
                  String sql = "INSERT INTO bus_runs_on(reg_no, route_id, capacity, model) "
                          + "VALUES(?,?,?,?,?)";
                  PreparedStatement pstmt = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
                  pstmt.setInt(1, c1);
                  pstmt.setInt(2, c2);
                  
                  pstmt.setInt(3, c3);
                  pstmt.setString(4, c4);
                  pstmt.setString(5, c5);
       
                  
                  int rowAffected = pstmt.executeUpdate();
                  if(rowAffected == 1)
                  {
                      
                      rs = pstmt.getGeneratedKeys();
                      
       
                  }
                  
                  }catch (SQLException ex) {
                      System.out.println(ex.getMessage());
                  } finally {
                      try {
                          if(rs != null)  rs.close();
                      } catch (SQLException e) {
                          System.out.println(e.getMessage());
                      }
                  }


                       break;
              
              case 2:
            	  System.out.println("Enter emp_id: ");
                  int b1= sc.nextInt();
                  System.out.println("Enter name: ");
                  String b2= sc.next();
                  System.out.println("Enter dob in yyyy-mm-dd format: ");
                  String b3= sc.next();
                
                  System.out.println("Enter reg number of bus he is assigned: ");
                  int b5= sc.nextInt();
                  System.out.println("Enter week day(s) he works: ");
                  String b6= sc.next();
                  
                  try {
               	   
               	   conn = DriverManager.getConnection(DB_URL, USER, PASS);
               	   try {
						Class.forName("com.mysql.cj.jdbc.Driver");
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
                  String sql = "INSERT INTO assistant_works_for(emp_id, name, dob, reg_no, day) "
                          + "VALUES(?,?,?,?,?)";
                  PreparedStatement pstmt = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
                  pstmt.setInt(1, b1);
                  pstmt.setString(2, b2);
                  pstmt.setString(3, b3);
                 
                  pstmt.setInt(4, b5);
                  pstmt.setString(5, b6);
       
                  
                  int rowAffected = pstmt.executeUpdate();
                  if(rowAffected == 1)
                  {
                      
                      rs = pstmt.getGeneratedKeys();
                      
       
                  }
                  
                  }catch (SQLException ex) {
                      System.out.println(ex.getMessage());
                  } finally {
                      try {
                          if(rs != null)  rs.close();
                      } catch (SQLException e) {
                          System.out.println(e.getMessage());
                      }
                  }

                  break;
              
              
              
              
              case 4:  
            	  System.out.println("Enter route_id: ");
                  int d1= sc.nextInt();
                  System.out.println("Enter route name: ");
                  String d2= sc.next();
                  System.out.println("Enter source stop name: ");
                  String d3= sc.next();
                
             
                  System.out.println("Enter destination stop name: ");
                  String d4= sc.next();
                  
                  try {
               	   
               	   conn = DriverManager.getConnection(DB_URL, USER, PASS);
               	   try {
						Class.forName("com.mysql.cj.jdbc.Driver");
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
                  String sql = "INSERT INTO route(route_id, rname, source, destination) "
                          + "VALUES(?,?,?,?)";
                  PreparedStatement pstmt = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
                  pstmt.setInt(1, d1);
                  pstmt.setString(2, d2);
                  
                  pstmt.setString(3, d3);
                  pstmt.setString(4, d4);
       
                  
                  int rowAffected = pstmt.executeUpdate();
                  if(rowAffected == 1)
                  {
                      
                      rs = pstmt.getGeneratedKeys();
                      
       
                  }
                  
                  }catch (SQLException ex) {
                      System.out.println(ex.getMessage());
                  } finally {
                      try {
                          if(rs != null)  rs.close();
                      } catch (SQLException e) {
                          System.out.println(e.getMessage());
                      }
                  }


                       break;
              
              case 5:  
            	  System.out.println("Enter stop_id: ");
                  int e1= sc.nextInt();
                  System.out.println("Enter name: ");
                  String e2= sc.next();
                  
                  
                  try {
               	   
               	   conn = DriverManager.getConnection(DB_URL, USER, PASS);
               	   try {
						Class.forName("com.mysql.cj.jdbc.Driver");
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
                  String sql = "INSERT INTO stop(stop_id, sname) "
                          + "VALUES(?,?)";
                  PreparedStatement pstmt = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
                  pstmt.setInt(1, e1);
                  pstmt.setString(2, e2);
                  
                  
                  
                  int rowAffected = pstmt.executeUpdate();
                  if(rowAffected == 1)
                  {
                      
                      rs = pstmt.getGeneratedKeys();
                      
       
                  }
                  
                  }catch (SQLException ex) {
                      System.out.println(ex.getMessage());
                  } finally {
                      try {
                          if(rs != null)  rs.close();
                      } catch (SQLException e) {
                          System.out.println(e.getMessage());
                      }
                  }


                       break;
              
              
              case 6:  
            	  System.out.println("Enter route_id: ");
                  int f1= sc.nextInt();
                  System.out.println("Enter stop_id: ");
                  int f2= sc.nextInt();
                  System.out.println("Enter order of the stop in the route: ");
                  int f3= sc.nextInt();
                
             
                  
                  
                  try {
               	   
               	   conn = DriverManager.getConnection(DB_URL, USER, PASS);
               	   try {
						Class.forName("com.mysql.cj.jdbc.Driver");
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
                  String sql = "INSERT INTO route_stops(route_id, stop_id, stop_order) "
                          + "VALUES(?,?,?)";
                  PreparedStatement pstmt = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
                  pstmt.setInt(1, f1);
                  pstmt.setInt(2, f2);
                  
                  pstmt.setInt(3, f3);
                  
       
                  
                  int rowAffected = pstmt.executeUpdate();
                  if(rowAffected == 1)
                  {
                      
                      rs = pstmt.getGeneratedKeys();
                      
       
                  }
                  
                  
                  String sqlUpdate = "UPDATE route_stops "
                          + "SET stop_order = stop_order+1 "
                          + "WHERE route_id = ? and stop_order> ? ";
                  PreparedStatement prstmt = conn.prepareStatement(sqlUpdate);
                  prstmt.setInt(1, f1);
                  prstmt.setInt(2, f3);
                  
                  rowAffected = prstmt.executeUpdate();
                  System.out.println(String.format("Row affected %d", rowAffected));
                  
                  }catch (SQLException ex) {
                      System.out.println(ex.getMessage());
                  } finally {
                      try {
                          if(rs != null)  rs.close();
                      } catch (SQLException e) {
                          System.out.println(e.getMessage());
                      }
                  }


                       break;
                 
              case 7:  
            	  System.out.println("Enter reg_no of the bus: ");
                  int g1= sc.nextInt();
                  System.out.println("Enter week day: ");
                  String g2= sc.next();
                  System.out.println("Enter departure time: ");
                  String g3= sc.next();
                  System.out.println("Enter route_id: ");
                  int g4= sc.nextInt();
                
             
                 
                  try {
               	   
               	   conn = DriverManager.getConnection(DB_URL, USER, PASS);
               	   try {
						Class.forName("com.mysql.cj.jdbc.Driver");
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
               
                
                
                String sqlUpdate = "UPDATE service_schedule "
                        + "SET day = '"+g2+"' , departure_time= '"+g3+"' , route_id="+g4+" "
                        + "WHERE reg_no = "+g1;
                PreparedStatement prstmt = conn.prepareStatement(sqlUpdate);
                
                
                
                int rowAffected = prstmt.executeUpdate();
                System.out.println(String.format("Row affected %d", rowAffected));
                
                }catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                } finally {
                    try {
                        if(rs != null)  rs.close();
                    } catch (SQLException e) {
                        System.out.println(e.getMessage());
                    }
                }


                     break;
               
              case 8:  
            	  System.out.println("Enter reg_no: ");
                  int h1= sc.nextInt();
                  
          
                  
                  try {
               	   
               	   conn = DriverManager.getConnection(DB_URL, USER, PASS);
               	   try {
						Class.forName("com.mysql.cj.jdbc.Driver");
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
               	   
               	String sql = "SELECT emp_id, name " +
                        "FROM driver_works_for "+ "where reg_no= "+h1;
               	
               	PreparedStatement prstmt = conn.prepareStatement(sql);
               	
               	
                ResultSet res    = prstmt.executeQuery(sql);
                System.out.println("emp_id" + "\t" + 
                        "name"  + "\t");
                while (res.next()) {
                    System.out.println(res.getString("emp_id") + "\t" + 
                                       res.getString("name")  + "\t");
                        
                }
                sql = "SELECT emp_id, name " +
                        "FROM assistant_works_for "+ "where reg_no= "+h1;
               	
               	 prstmt = conn.prepareStatement(sql);
               
               	
                res    = prstmt.executeQuery(sql);
                while (res.next()) {
                    System.out.println(res.getString("emp_id") + "\t" + 
                                       res.getString("name")  + "\t");
                        
                }
                  
                  }catch (SQLException ex) {
                      System.out.println(ex.getMessage());
                  } finally {
                      try {
                          if(rs != null)  rs.close();
                      } catch (SQLException e) {
                          System.out.println(e.getMessage());
                      }
                  }


                       break;       
                       
              case 9:  
            	  System.out.println("Enter first stop_id: ");
                  int i1= sc.nextInt();
                  System.out.println("Enter second stop_id: ");
                  int i2= sc.nextInt();
                  System.out.println("Enter day: ");
                  String i3= sc.next();
                  
          
                  
                  try {
               	   
               	   conn = DriverManager.getConnection(DB_URL, USER, PASS);
               	   try {
						Class.forName("com.mysql.cj.jdbc.Driver");
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
               	   
               	String sql = "SELECT bus_runs_on.reg_no, capacity, model, departure_time, service_schedule.route_id, features from bus_runs_on  join service_schedule "
               			+ "on bus_runs_on.reg_no = service_schedule.reg_no "
               			+ "where service_schedule.day= '"+i3+"' "
               			+ "and service_schedule.route_id in (select R1.route_id from route_stops R1, route_stops R2 "
               			+ "where R1.route_id = R2.route_id and "
               			+ "R1.stop_id="+i1+" and R2.stop_id= "+i2+" ) ";
               	
               	PreparedStatement prstmt = conn.prepareStatement(sql);
               	
               	
               	
                ResultSet res    = prstmt.executeQuery(sql);
                System.out.println("reg_no" + "\t" + 
                       "capacity"  + "\t"+"model"  + "\t\t"+"departure_time"  +"\t\t"+"on route_id" + "\t\t"+ "bus features");
                while (res.next()) {
                    System.out.println(res.getInt("bus_runs_on.reg_no") + "\t" + 
                                       res.getString("bus_runs_on.capacity")  + 
                                       "\t\t"+res.getString("bus_runs_on.model")  + 
                                       "\t\t"+res.getString("service_schedule.departure_time")  +
                                       "\t\t"+res.getString("service_schedule.route_id") + "\t\t\t"
                                       +res.getString("bus_runs_on.features"));
                        
                }
                  
                  }catch (SQLException ex) {
                      System.out.println(ex.getMessage());
                  } finally {
                      try {
                          if(rs != null)  rs.close();
                      } catch (SQLException e) {
                          System.out.println(e.getMessage());
                      }
                  }


                       break;       
                       
              case 10:  
            	  System.out.println("Enter first stop_id: ");
                  int j1= sc.nextInt();
                  System.out.println("Enter second stop_id: ");
                  int j2= sc.nextInt();
                  
                  
          
                  
                  try {
               	   
               	   conn = DriverManager.getConnection(DB_URL, USER, PASS);
               	   try {
						Class.forName("com.mysql.cj.jdbc.Driver");
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
               	   
               	String sql = "SELECT rs.route_id,s.stop_id,s.sname, rs.stop_order" + 
               			" from route_stops rs  join stop s"+ 
               			" on rs.stop_id = s.stop_id"
               			+ " where rs.route_id in(select R1.route_id from (route_stops R1, route_stops R2)"
               			+ " where R1.route_id = R2.route_id and"
               			+ " R1.stop_id= '"+j1+"' and R2.stop_id= '"+j2+"' ) "
               			+"order by rs.stop_order";
               	
               	PreparedStatement prstmt = conn.prepareStatement(sql);
               	
               	
               	
               	
                ResultSet res    = prstmt.executeQuery(sql);
                System.out.println("route_id" + "\t" + "stop id" + "\t\t" +
                       "stop name" + "\t" + 
                       "stop order" );
                while (res.next()) {
                    System.out.println(res.getInt("rs.route_id") + "\t\t" + 
                    		res.getString("s.stop_id") + "\t\t" + 
                                       res.getString("s.sname") + "\t\t" + 
                                       res.getString("rs.stop_order") );
                        
                }
                  
                  }catch (SQLException ex) {
                      System.out.println(ex.getMessage());
                  } finally {
                      try {
                          if(rs != null)  rs.close();
                      } catch (SQLException e) {
                          System.out.println(e.getMessage());
                      }
                  }


                       break;       
                       
              case 11:  
          
                  try {
               	   
               	   conn = DriverManager.getConnection(DB_URL, USER, PASS);
               	   try {
						Class.forName("com.mysql.cj.jdbc.Driver");
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
               	   
               	String sql = "SELECT route_id,rname,source,destination" + 
               			" from route ";
               			
               	
               	PreparedStatement prstmt = conn.prepareStatement(sql);
               	
               	
               	
               	
                ResultSet res    = prstmt.executeQuery(sql);
                System.out.println("route_id" + "\t" + "route name" + "\t\t\t" + 
                       "source"+"\t\t" + "destination" );
                while (res.next()) {
                    System.out.println(res.getInt("route_id") + "\t\t" + 
                    		res.getString("rname") + "\t\t" + 
                    		res.getString("source") + "\t\t" +
                                       res.getString("destination") );
                        
                }
                  
                  }catch (SQLException ex) {
                      System.out.println(ex.getMessage());
                  } finally {
                      try {
                          if(rs != null)  rs.close();
                      } catch (SQLException e) {
                          System.out.println(e.getMessage());
                      }
                  }


                       break;       
                       
              case 12:  
                  
                  try {
               	   
               	   conn = DriverManager.getConnection(DB_URL, USER, PASS);
               	   try {
						Class.forName("com.mysql.cj.jdbc.Driver");
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
               	   
               	String sql = "SELECT stop_id, sname" + 
               			" from stop ";
               			
               	
               	PreparedStatement prstmt = conn.prepareStatement(sql);
               	
               	
               	
               	
                ResultSet res    = prstmt.executeQuery(sql);
                System.out.println("stop_id" + "\t\t" + "stop name"  );
                while (res.next()) {
                    System.out.println(res.getInt("stop_id") + "\t\t" + 
                    		res.getString("sname") );
                        
                }
                  
                  }catch (SQLException ex) {
                      System.out.println(ex.getMessage());
                  } finally {
                      try {
                          if(rs != null)  rs.close();
                      } catch (SQLException e) {
                          System.out.println(e.getMessage());
                      }
                  }


                       break;       
              
              case 13:  
            	  
                  try {
               	   
               	   conn = DriverManager.getConnection(DB_URL, USER, PASS);
               	   try {
						Class.forName("com.mysql.cj.jdbc.Driver");
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
               	   
               	String sql = "SELECT reg_no, capacity, model, features from bus_runs_on  ";
               			
               	
               	PreparedStatement prstmt = conn.prepareStatement(sql);
               	
               	
               	
                ResultSet res    = prstmt.executeQuery(sql);
                System.out.println("reg_no" + "\t" + 
                       "capacity"  + "\t"+"model"  + "\t\t"+ "bus features");
                while (res.next()) {
                    System.out.println(res.getInt("reg_no") + "\t" + 
                                       res.getString("capacity")  + 
                                       "\t\t"+res.getString("model")  + 
                                        "\t\t"
                                       +res.getString("bus_runs_on.features"));
                        
                }
                  
                  }catch (SQLException ex) {
                      System.out.println(ex.getMessage());
                  } finally {
                      try {
                          if(rs != null)  rs.close();
                      } catch (SQLException e) {
                          System.out.println(e.getMessage());
                      }
                  }


                       break;       
              
              case 20:System.exit(0);
              default: System.out.println("Wrong Entry");
           }
      }
  
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      

      
     // stmt.executeUpdate(sql);

     // sql  = "use STUDENTS";

     // stmt.executeUpdate(sql);
      

     

   


      

      

  // System.out.println("Goodbye!");

  }

}
