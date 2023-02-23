import java.util.concurrent.locks.Condition;

public class Condicionales{
    private String Condicion;
      
  
      public Condicionales(){
            Condicion = "";
            
      }
  
  
  
  public Condicionales(String Condicion){
      this.Condicion = Condicion;
   
  }
  

    
    /** 
     * @return String
     */
    public String getCondicion() {
        return this.Condicion;
    }

    public void setCondicion(String Condicion) {
        this.Condicion = Condicion;
    }

    public boolean siescondicional( String Condition){
        boolean condicional = true;
        if(Condition.matches("[cond, and, or, else]")){
            condicional = true;

            switch(Condition){


                case "cond":{
                    
                    break;
                }

                case "and":{

                    break;
                }

                case "or":{

                    break;
                }

                case "else":{

                    break;
                }
            }
        }
        
        
        return condicional;
        
    }
  
  
  }
  
      
  