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
        if(Condicion.matches("[if, cond, and, or, else]")){
            condicional = true;
        }
        
        
        return condicional;
        
    }
  
  
  }
  
      
  