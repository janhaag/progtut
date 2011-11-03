
      public class Auto {
         final String marke;
         Karosserie karosserie;
         Motor motor;

         public Auto(String marke, Karosserie karosserie, Motor motor) {
             this.marke = marke;
             this.karosserie = karosserie;
             this.motor = motor;
         }

         String getMarke() {
             return marke;
         }

         void setMotor(Motor motor) {
             this.motor = motor;
         }

         public static void main(String[] args) {
             Auto a = new Auto("BMW", new Karosserie(), new Motor());
             System.out.println(a.getMarke());
         }
      }
