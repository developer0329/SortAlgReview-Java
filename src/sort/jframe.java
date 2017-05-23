package sort;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;


import com.behrooz.*;
import com.behrooz.sorting.MyBubbleSort;
import com.behrooz.sorting.MyInsertionSort;
import com.behrooz.sorting.MyMergeSort;
import com.behrooz.sorting.MyQuickSort;
import com.behrooz.sorting.MyRadixSort;
import com.behrooz.sorting.MySelectionSort;

public class jframe {

	private JFrame frame;
	private JTextField txtLength;
	private JTextField txtMaxValue;
	private JLabel lblStatus;
	private JTextField txtQuick;
	private JTextField txtMerge;
	private JTextField txtInsertion;
	private JTextField txtSelection;
	private JTextField txtBubble;
	private JTextField txtRadix;
	private JTextArea txtUnsortedArray;
	private JTextArea txtSortedArray;
	private int[] data0;
	private int[] READ_DATA;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					jframe window = new jframe();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public jframe() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 508, 491);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("");
		label.setBounds(0, 0, 517, 0);
		frame.getContentPane().add(label);
		
		JLabel lblNewLabel = new JLabel("Array Length");
		lblNewLabel.setBounds(21, 11, 74, 23);
		frame.getContentPane().add(lblNewLabel);
		
		txtLength = new JTextField();
		txtLength.setBounds(101, 11, 86, 20);
		frame.getContentPane().add(txtLength);
		txtLength.setColumns(10);
		
		JButton btnNewButton = new JButton("Generate");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String fileName = "random.txt";
				try {
					PrintWriter outputStream = new PrintWriter(fileName);
					
					//Scanner reader = new Scanner(System.in);  // Reading from System.in
					//System.out.println("Please enter the length of array: ");
					//final int LENGTH = reader.nextInt();
					final int LENGTH = Integer.parseInt(txtLength.getText());
					
					//System.out.println("Please enter max range of array: ");
					//final int RANGE = reader.nextInt();
					final int RANGE = Integer.parseInt(txtMaxValue.getText());
					
					int[] array1 = new int[LENGTH];			//Generate n random numbers
					for(int i = 0; i <  array1.length; i++) {
						array1[i] = (int)(Math.random() * RANGE);
						outputStream.println(array1[i]);	//Store in RAM
					}
					outputStream.close(); //Flushes data to file
					lblStatus.setText("txt file generated successfully.");
					//System.out.println("Done.");
					
					READ_DATA = readFiles("random.txt");

					//using built-in "Quicksort" Arrays.sort method
					data0 = READ_DATA;
					txtUnsortedArray.setText(Arrays.toString(data0));
					//System.out.println("Unsorted Array:");
					//System.out.println(Arrays.toString(data0));
					
					
				} catch (FileNotFoundException err) {
					// TODO Auto-generated catch block
					err.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(395, 11, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnTest = new JButton("Sort");
		btnTest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblStatus.setText("");
				Arrays.sort(data0);
				txtSortedArray.setText(Arrays.toString(data0));
				
				MyQuickSort sorter1 = new MyQuickSort();
				int[] data1 = READ_DATA;
				long startTime1 = System.nanoTime();
				sorter1.sort(data1);
				long stopTime1 = System.nanoTime();
				txtQuick.setText(Long.toString(stopTime1 - startTime1));


				MyMergeSort sorter2 = new MyMergeSort();
				int[] data2 = READ_DATA;
				long startTime2 = System.nanoTime();
				sorter2.sort(data2);
				long stopTime2 = System.nanoTime();
				//System.out.println("Mergesort: " + (stopTime2 - startTime2));
				//System.out.println("---------------------------------------");
				txtMerge.setText(Long.toString(stopTime2 - startTime2));
				
				
				int[] data3 = READ_DATA;
				long startTime3 = System.nanoTime();
				MyInsertionSort.doInsertionSort(data3);
				long stopTime3 = System.nanoTime();
				//System.out.println("Insertion Sort: " + (stopTime3 - startTime3));
				//System.out.println("---------------------------------------");
				txtInsertion.setText(Long.toString(stopTime3 - startTime3));
				
				int[] data4 = READ_DATA;
				long startTime4 = System.nanoTime();
				MySelectionSort.doSelectionSort(data4);
				long stopTime4 = System.nanoTime();
				//System.out.println("Selection Sort: " + (stopTime4 - startTime4));
				//System.out.println("---------------------------------------");
				txtSelection.setText(Long.toString(stopTime4 - startTime4));
				
				int[] data5 = READ_DATA;
				long startTime5 = System.nanoTime();
				MyBubbleSort.bubble_srt(data5);
				long stopTime5 = System.nanoTime();
				//System.out.println("Bubble Sort: " + (stopTime5 - startTime5));
				//System.out.println("---------------------------------------");
				txtBubble.setText(Long.toString(stopTime5 - startTime5));
				
				int[] data6 = READ_DATA;
		        int n = data6.length;
				long startTime6 = System.nanoTime();
				MyRadixSort.radixsort(data6, n);
				long stopTime6 = System.nanoTime();	
				//System.out.println("Radix Sort: " + (stopTime6 - startTime6));
				//System.out.println("---------------------------------------");  */
				txtRadix.setText(Long.toString(stopTime6 - startTime6));
				lblStatus.setText("sorted successfully.");
			}
		});
		btnTest.setBounds(226, 136, 89, 23);
		frame.getContentPane().add(btnTest);
		
		JLabel lblMaxValue = new JLabel("Max Value");
		lblMaxValue.setBounds(197, 11, 76, 20);
		frame.getContentPane().add(lblMaxValue);
		
		txtMaxValue = new JTextField();
		txtMaxValue.setBounds(267, 11, 86, 20);
		frame.getContentPane().add(txtMaxValue);
		txtMaxValue.setColumns(10);
		
		lblStatus = new JLabel("");
		lblStatus.setForeground(Color.BLUE);
		lblStatus.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblStatus.setBounds(156, 396, 197, 34);
		frame.getContentPane().add(lblStatus);
		
		JLabel lblUnsortedArray = new JLabel("Unsorted Array");
		lblUnsortedArray.setBounds(9, 57, 86, 23);
		frame.getContentPane().add(lblUnsortedArray);
		
		JLabel lblSortedArray = new JLabel("Sorted Array");
		lblSortedArray.setBounds(9, 160, 86, 34);
		frame.getContentPane().add(lblSortedArray);
		
		txtUnsortedArray = new JTextArea();
		txtUnsortedArray.setEditable(false);
		txtUnsortedArray.setWrapStyleWord(true);
		txtUnsortedArray.setRows(10);
		txtUnsortedArray.setLineWrap(true);
		
		
		JScrollPane scroll = new JScrollPane (txtUnsortedArray, 
				   JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scroll.setBounds(105, 55, 379, 70);
		frame.getContentPane().add(scroll);
		
		txtSortedArray = new JTextArea();
		txtSortedArray.setLineWrap(true);
		txtSortedArray.setEditable(false);
	//	txtSortedArray.setBounds(105, 160, 379, 34);
		
		
		JScrollPane scroll_sorted = new JScrollPane (txtSortedArray, 
				   JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scroll_sorted.setBounds(105, 170, 379, 70);
		frame.getContentPane().add(scroll_sorted);
		//frame.getContentPane().add(txtSortedArray);
		
		JLabel lblQuickSort = new JLabel("Quick Sort");
		lblQuickSort.setBounds(41, 257, 66, 23);
		frame.getContentPane().add(lblQuickSort);
		
		JLabel lblMergeSort = new JLabel("Merge Sort");
		lblMergeSort.setBounds(41, 301, 66, 23);
		frame.getContentPane().add(lblMergeSort);
		
		JLabel lblInsertionSort = new JLabel("Insertion Sort");
		lblInsertionSort.setBounds(21, 344, 96, 23);
		frame.getContentPane().add(lblInsertionSort);
		
		JLabel lblSelectionSort = new JLabel("Selection Sort");
		lblSelectionSort.setBounds(281, 344, 86, 23);
		frame.getContentPane().add(lblSelectionSort);
		
		JLabel lblBubbleSort = new JLabel("Bubble Sort");
		lblBubbleSort.setBounds(281, 257, 72, 23);
		frame.getContentPane().add(lblBubbleSort);
		
		JLabel lblRadixSort = new JLabel("Radix Sort");
		lblRadixSort.setBounds(281, 301, 72, 23);
		frame.getContentPane().add(lblRadixSort);
		
		txtQuick = new JTextField();
		txtQuick.setEditable(false);
		txtQuick.setBounds(127, 258, 86, 20);
		frame.getContentPane().add(txtQuick);
		txtQuick.setColumns(10);
		
		txtMerge = new JTextField();
		txtMerge.setEditable(false);
		txtMerge.setColumns(10);
		txtMerge.setBounds(127, 302, 86, 20);
		frame.getContentPane().add(txtMerge);
		
		txtInsertion = new JTextField();
		txtInsertion.setEditable(false);
		txtInsertion.setColumns(10);
		txtInsertion.setBounds(127, 345, 86, 20);
		frame.getContentPane().add(txtInsertion);
		
		txtSelection = new JTextField();
		txtSelection.setEditable(false);
		txtSelection.setColumns(10);
		txtSelection.setBounds(373, 345, 86, 20);
		frame.getContentPane().add(txtSelection);
		
		txtBubble = new JTextField();
		txtBubble.setEditable(false);
		txtBubble.setColumns(10);
		txtBubble.setBounds(373, 258, 86, 20);
		frame.getContentPane().add(txtBubble);
		
		txtRadix = new JTextField();
		txtRadix.setEditable(false);
		txtRadix.setColumns(10);
		txtRadix.setBounds(373, 302, 86, 20);
		frame.getContentPane().add(txtRadix);
	}
	
	public static int[] readFiles(String file){		
		try {
			File f = new File(file);
			Scanner s1 = new Scanner(f);
			
			int counter = 0;
			while (s1.hasNextInt()){
				counter++;
				s1.nextInt();
			}
			
			//System.out.println("Total number of integers read was: " + counter);
			
			int[] readArray = new int[counter];	//create an array with length of our counter
			Scanner s2 = new Scanner(f);
			
			for (int i = 0; i<readArray.length; i++)
				readArray[i] = s2.nextInt();
			return readArray;
		}		
		catch(Exception e) {
			return null;	//If it reads any other data types other than int it will return null
		}
	}
}
