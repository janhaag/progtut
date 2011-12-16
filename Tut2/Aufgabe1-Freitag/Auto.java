       class Auto {
           int leistung;
           final String hersteller;
           Karosserie karosserie;

           public Auto(int leistung, String hersteller, Karosserie karosserie) {
               setLeistung(leistung);
               this.hersteller = hersteller;
               setKarosserie(karosserie);
           }

           void setLeistung(int leistung) {
               this.leistung = leistung;
           }

           void setKarosserie(Karosserie karosserie) {
               this.karosserie = karosserie;
           }

           int getLeistung() {
               return leistung;
           }

           Karosserie getKarosserie() {
               return karosserie;
           }

           String getHersteller() {
               return hersteller;
           }

           public static void main(String[] args) {
               Auto meinAuto = new Auto(5, "Mercedes", new Karosserie());
               System.out.println(meinAuto.getHersteller());
               meinAuto.setLeistung(500);
               System.out.println(meinAuto.getLeistung());
           }
       }

