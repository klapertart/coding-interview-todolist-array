package klapertart.lab.citodolist.data;

/**
 * @author kurakuraninja
 * @since 27/12/22
 */

public class ToDoList {
    private String[] array = new String[2];
    private int index = 0;

    public void add(String value){
        if(isFull()){
            array = resize();
        }

        array[index] = value;
        index++;
    }

    public String[] get(){
        return array;
    }

    public boolean remove(int position){
        // cek datanya apakah tidak kosong
        if(position >= 1 && position <= index){
            for (int i = (position-1); i < index; i++) {
                if((i+1) == index){
                    array[i] = null;
                }else if((i+1) < index){
                    array[i] = array[i+1];
                }
            }
            return true;
        }else{
            return false;
        }
    }

    private String[] resize(){
        String[] temp = new String[array.length+1];

        for (int i = 0; i < array.length; i++) {
            temp[i] = array[i];
        }

        return temp;
    }

    private boolean isFull(){
        return index == (array.length);
    }
}
