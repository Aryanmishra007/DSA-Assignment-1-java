// File: WeatherAssignment.java
import java.time.LocalDate;
import java.util.*;

public class WeatherAssignment {
    // WeatherRecord ADT
    static class WeatherRecord {
        LocalDate date; String city; double temp;
        WeatherRecord(LocalDate d,String c,double t){ date=d; city=c; temp=t; }
    }

    // Dense 2D Array Storage
    static class DenseStorage {
        int baseYear; List<String> cities; Map<String,Integer> cityIndex; double[][] data;
        DenseStorage(int base,int end,List<String> c){
            baseYear=base; cities=c; cityIndex=new HashMap<>();
            for(int i=0;i<c.size();i++) cityIndex.put(c.get(i).toLowerCase(),i);
            data=new double[end-base+1][c.size()];
            for(double[] row:data) Arrays.fill(row,Double.NaN);
        }
        void insert(WeatherRecord r){ data[r.date.getYear()-baseYear][cityIndex.get(r.city.toLowerCase())]=r.temp; }
        void delete(String city,LocalDate d){ data[d.getYear()-baseYear][cityIndex.get(city.toLowerCase())]=Double.NaN; }
        String retrieve(String city,int year){
            int r=year-baseYear, c=cityIndex.getOrDefault(city.toLowerCase(),-1);
            if(c==-1||r<0||r>=data.length) return "City/Year not valid.";
            double v=data[r][c];
            return Double.isNaN(v) ? "No record found for "+city+" in "+year : city+" "+year+" -> "+v+"°C";
        }
    }

    // Sparse Storage
    static class SparseStorage {
        Map<String,Double> map=new HashMap<>();
        String key(LocalDate d,String c){ return d.getYear()+"-"+c.toLowerCase(); }
        void insert(WeatherRecord r){ map.put(key(r.date,r.city),r.temp); }
        void delete(String c,LocalDate d){ map.remove(key(d,c)); }
        String retrieve(String c,int y){
            Double v=map.get(y+"-"+c.toLowerCase());
            return v==null ? "No record found for "+c+" in "+y : c+" "+y+" -> "+v+"°C";
        }
    }

    // ===== Main Interactive Program =====
    public static void main(String[] args) {
        List<String> cities=Arrays.asList("Delhi","Mumbai","Chennai","Kolkata","Bengaluru");
        DenseStorage dense=new DenseStorage(2021,2025,cities);
        SparseStorage sparse=new SparseStorage();

        // Preloaded sample data
        dense.insert(new WeatherRecord(LocalDate.of(2021,1,10),"Delhi",15.2));
        dense.insert(new WeatherRecord(LocalDate.of(2022,5,20),"Mumbai",30.5));
        dense.insert(new WeatherRecord(LocalDate.of(2023,7,12),"Chennai",34.8));
        dense.insert(new WeatherRecord(LocalDate.of(2024,8,5),"Kolkata",32.1));
        dense.insert(new WeatherRecord(LocalDate.of(2025,3,5),"Bengaluru",20.3));

        sparse.insert(new WeatherRecord(LocalDate.of(2021,1,10),"Delhi",15.2));
        sparse.insert(new WeatherRecord(LocalDate.of(2023,7,12),"Chennai",34.8));
        sparse.insert(new WeatherRecord(LocalDate.of(2025,3,5),"Bengaluru",20.3));

        Scanner sc=new Scanner(System.in);
        System.out.println("=== Weather Data System ===");
        System.out.println("Available cities: "+cities);

        while(true){
            System.out.print("\nChoose option: 1=Retrieve  2=Insert  3=Delete  4=Exit : ");
            int choice=Integer.parseInt(sc.nextLine());

            if(choice==4) break;

            if(choice==1){ // Retrieve
                System.out.print("Enter city: "); String city=sc.nextLine();
                System.out.print("Enter year (2021-2025): "); int year=Integer.parseInt(sc.nextLine());
                System.out.println("[Dense] "+dense.retrieve(city,year));
                System.out.println("[Sparse] "+sparse.retrieve(city,year));
            }
            else if(choice==2){ // Insert
                System.out.print("Enter city: "); String city=sc.nextLine();
                System.out.print("Enter year (2021-2025): "); int year=Integer.parseInt(sc.nextLine());
                System.out.print("Enter temperature: "); double temp=Double.parseDouble(sc.nextLine());
                LocalDate d=LocalDate.of(year,1,1);
                WeatherRecord r=new WeatherRecord(d,city,temp);
                dense.insert(r); sparse.insert(r);
                System.out.println("Inserted "+city+" "+year+" -> "+temp+"°C");
            }
            else if(choice==3){ // Delete
                System.out.print("Enter city: "); String city=sc.nextLine();
                System.out.print("Enter year (2021-2025): "); int year=Integer.parseInt(sc.nextLine());
                LocalDate d=LocalDate.of(year,1,1);
                dense.delete(city,d); sparse.delete(city,d);
                System.out.println("Deleted record for "+city+" "+year);
            }
            else {
                System.out.println("Invalid choice!");
            }
        }

        // Complexity summary at exit
        System.out.println("\n=== Complexity Analysis ===");
        System.out.println("Insert/Delete/Retrieve: O(1)");
        System.out.println("Traversal: O(R*C)");
        System.out.println("Dense Space: O(R*C)");
        System.out.println("Sparse Space: O(K)");
        System.out.println("=== Program End ===");
    }
}
