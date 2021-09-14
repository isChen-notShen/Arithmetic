package ind.chen.adt.imp;

import ind.chen.adt.imp.ResizingArrayStack;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ResizingArrayStackTest {
    private Scanner scanner;
    private ResizingArrayStack<String> stack;


    @Before
    public void load(){
        File tobe = new File("src/test/resources/ind/chen/adt/tobe.txt");
        try {
            scanner = new Scanner(new BufferedInputStream(new FileInputStream(tobe)));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        stack = new ResizingArrayStack<>();
    }

    @After
    public void unload(){
        scanner.close();
    }

    @Test
    public void push() {
        String item = null;
        System.out.print("Input: ");
        while (scanner.hasNext()){
            item = scanner.next();
            System.out.print(item + " ");
            if (item.equals("-"))
                stack.pop();
            else
                stack.push(item);
        }
        System.out.print("\n" + stack);
    }
}