package ua.edu.ucu.collections.immutable;
import java.lang.IndexOutOfBoundsException;

public class ImmutableArrayList implements ImmutableList{
    protected final Object[] object_list;

    public ImmutableArrayList(Object[] object_list){
        this.object_list = object_list;
    }

    public ImmutableList add(Object e){
        Object[] new_object_list = new Object[size() + 1];
        for ( int i = 0; i < size(); i++){
            new_object_list[i] = this.object_list[i];
        }
        new_object_list[-1] = e;
        ImmutableArrayList arrayList = new ImmutableArrayList(new_object_list);
        return arrayList;
    }

    public ImmutableList add(int index, Object e) throws IndexOutOfBoundsException{
        Object[] new_obect_list = new Object[size() + 1];
        if (size() - 1 < index ) {
            throw new IndexOutOfBoundsException();
        }
        for (int i = 0; i < index - 1; i ++  ){
            new_obect_list[i] = this.object_list[i];
        }
        new_obect_list[index] = e;
        for ( int i = index + 1; i < size(); i ++){
            new_obect_list[i] = this.object_list;
        }
        ImmutableArrayList arrayList = new ImmutableArrayList(new_obect_list);
        return arrayList;
    }

    public ImmutableList addAll(Object[] c){
        Object[] new_obect_list = new Object[size() + c.length];
        for (int i = 0; i < size(); i ++){
            new_obect_list[i] = this.object_list[i];
        }
        for (int i = size(); i < (size() + c.length); i ++){
            new_obect_list[i] = c[i];
        }
        ImmutableArrayList arrayList = new ImmutableArrayList(new_obect_list);
        return arrayList;
    }

    public ImmutableList addAll(int index, Object[] c) throws IndexOutOfBoundsException {
        if (index > size()){
            throw new IndexOutOfBoundsException();
        }
        Object[] new_obect_list = new Object[size() + c.length];
        for (int i = 0; i < index - 1; i ++ ){
            new_obect_list[i] = this.object_list[i];
        }
        for (int i = index; i < c.length + index; i ++){
            new_obect_list[i] = c[i];
        }
        for (int i = c.length + index; i < (c.length + size()); i ++){
            new_obect_list[i] = c[i];
        }
        ImmutableArrayList arrayList = new ImmutableArrayList(new_obect_list);
        return arrayList;
    }

    public Object get(int index) throws IndexOutOfBoundsException {
        if (index > size()){
            throw new IndexOutOfBoundsException();
        }
        return this.object_list[index];
    }

    public ImmutableList remove(int index) throws IndexOutOfBoundsException {
        if (index > size()){
            throw new IndexOutOfBoundsException();
        }
        Object[] new_obect_list = new Object[size() - 1];
        for (int i = 0; i < index; i ++){
            new_obect_list[i] = this.object_list[i];
        }
        for (int i = index + 1; i < size(); i ++){
            new_obect_list[i-1] = this.object_list[i];
        }
        ImmutableArrayList arrayList = new ImmutableArrayList(new_obect_list);
        return arrayList;
    }

    public ImmutableList set(int index, Object e) throws IndexOutOfBoundsException{
        if (index > size()){
            throw new IndexOutOfBoundsException();
        }
        Object[] new_obect_list = new Object[size()];
        for (int i = 0; i < index; i ++){
            new_obect_list[i] = this.object_list[i];
        }
        new_obect_list[index] = e;
        for (int i = index + 1; i < size(); i ++){
            new_obect_list[i] = this.object_list[i];
        }
        ImmutableArrayList arrayList = new ImmutableArrayList(new_obect_list);
        return arrayList;
    }

    public int indexOf(Object e){
        for (int i = 0; i < size(); i ++){
            if (this.object_list[i] == e){
                return  i;
            }
        }
        return -1;
    }

    public int size(){
        return object_list.length;
    }

    public ImmutableList clear(){
        Object[] new_obect_list = new Object[0];
        ImmutableArrayList arrayList = new ImmutableArrayList(new_obect_list);
        return arrayList;
    }

    public boolean isEmpty(){
        if (size() == 0){
            return true;
        }
        return false;
    }

    public Object[] toArray(){
        Object[] new_obect_list = new Object[size()];
        for (int i = 0; i < size(); i ++){
            new_obect_list[i] = this.object_list[i];
        }
        return new_obect_list;
    }

    @Override

    public String toString(){
        String str = " ";
        for (int i = 0; i < size() - 1; i ++){
            str += this.object_list[i] + ",";
        }
        str += this.object_list[-1];
        return str;
    }
}
