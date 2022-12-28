package klapertart.lab.citodolist;

import klapertart.lab.citodolist.data.ToDoList;
import java.util.Scanner;

public class App {
    static Scanner scanner = new Scanner(System.in);
    static ToDoList toDoList = new ToDoList();

    public static void main( String[] args ){
        viewTodolist();
    }

    public static String input(String info){
        System.out.print(info + " : " );
        String input = scanner.nextLine();
        return input;
    }

    public static void showTodolist(){
        String[] tempTDL = toDoList.get();
        for (int i = 0; i < tempTDL.length; i++) {
            if (tempTDL[i] != null){
                System.out.println((i+1) +". " + tempTDL[i]);
            }
        }
    }

    public static void viewTodolist(){
        while (true){
            System.out.println("------ TODOLIST-----");

            // menampilkan to do list
            showTodolist();

            // input pilihan
            System.out.println("MENU");
            System.out.println("1. Tambah");
            System.out.println("2. Hapus");
            System.out.println("3. Keluar");

            String menu = input("Pilih");

            if (menu.equals("1")){
                viewAddTodolist();
            }else if (menu.equals("2")){
                viewRemoveTodolist();
            }else if(menu.equals("3")){
                break;
            }else{
                System.out.println("Pilihan menu tidak valid");
            }
        }
    }

    public static void viewAddTodolist(){
        String value = input("Input Todolist (x jika batal)");

        if (value.equals("x")){
        }else{
            toDoList.add(value);
        }
    }

    public static void viewRemoveTodolist(){
        String value = input("Input nomor todo (x jika batal)");

        if (value.equals("x")){
        }else{
            if(isDigits(value)){
                boolean result = toDoList.remove(Integer.valueOf(value));
                if(result){
                    System.out.println("Todo nomor " + value + " BERHASIL dihapus");
                }else{
                    System.out.println("Todo nomor " + value + " GAGAL dihapus");
                }
            }else{
                System.out.println("Pilihan nomor tidak valid");
            }
        }
    }

    public static boolean isDigits(String value){
        for (int i = 0; i < value.length(); i++) {
            if(!Character.isDigit(value.charAt(i))){
                return false;
            }
        }
        return true;
    }




    ///----------------------------- UNIT TEST

    public static void testIsDigits(){
        boolean result = isDigits("asdf");
        if(!result){
            System.out.println("VALID 1");
        }

        result = isDigits("123");
        if(result){
            System.out.println("VALID 2");
        }

        result = isDigits("12as3");
        if(!result){
            System.out.println("VALID 3");
        }

        result = isDigits("1");
        if(result){
            System.out.println("VALID 4");
        }

        result = isDigits("x");
        if(!result){
            System.out.println("VALID 5");
        }

    }

    public static void testInput() {
        String name = input("Nama");
        System.out.println("Hi " + name);

        String alamat = input("Alamat");
        System.out.println("Hi " + alamat);
    }

    public static void testShowTodolist(){
        toDoList.add("satu");
        toDoList.add("dua");
        toDoList.add("tiga");

        showTodolist();
    }

    public static void testViewAddTodolist(){
        toDoList.add("satu");
        toDoList.add("dua");
        toDoList.add("tiga");

        showTodolist();

        viewAddTodolist();

        showTodolist();
    }

    public static void testViewRemoveTodolist(){
        toDoList.add("satu");
        toDoList.add("dua");
        toDoList.add("tiga");

        showTodolist();

        viewRemoveTodolist();

        showTodolist();
    }

    public static void testViewTodolist(){
/*
        toDoList.add("satu");
        toDoList.add("dua");
        toDoList.add("tiga");
*/

        viewTodolist();
    }
}
