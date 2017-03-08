package edu.jsu.mcis;

import org.junit.*;
import static org.junit.Assert.*;
import java.io.*;
import javax.swing.*;
import java.awt.*;

public class MainTest{

	private ByteArrayOutputStream out;
	private String[] validCourseArgs = {"course", "99000"};
	private String[] invalidCourseArgs = {"course", "00"};
	private String[] validStudentArgs = {"student", "111111"};
	private String[] invalidStudentArgs = {"student", "111500"};
	private String[] invalidFirstArg = {"Happy", "111111"};
	private String[] courseIDsArg = {"courseids"};
	private String[] studentIDsArg = {"studentids"};
	
	@Before
	public void setup(){
		out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(out));
	}
	
	@Test
	public void testCorrectStudentArgsYieldCorrectOutput(){
		Main.main(validStudentArgs);
		assertEquals("[111111] Jerrod Shields jshields@jsu.edu", out.toString().trim());
	}

	@Test
	public void testInvalidStudentArgsThrowsStudentException(){
		boolean thrown = false;
		try{
			Main.main(invalidStudentArgs);
		}
		catch(StudentException s){
			thrown = true;
		}
		assertTrue(thrown);
	}

	@Test
	public void testCorrectCourseArgsYieldCorrectOutput(){
		Main.main(validCourseArgs);
		assertEquals("[99000] Spring 2013 (11 students)", out.toString().trim());
	}
	
	@Test
	public void testInvalidCourseArgsThrowsCourseException(){
		boolean thrown = false;
		try{
				Main.main(invalidCourseArgs);
		}
		catch(CourseException s){
			thrown = true;
		}
		assertTrue(thrown);
	}
	
	@Test
	public void testCorrectSingleArgYieldsCorrectOutput1(){
		Main.main(courseIDsArg);
		assertEquals("99000\n99001\n99002\n99003\n99004\n99005\n99006\n99007\n99008\n99009\n99010\n99011\n99012\n99013\n99014\n99015\n99016\n99017\n99018\n99019\n99020\n99021\n99022\n99023\n99024",
		out.toString().trim());
	}
	
	@Test
	public void testCorrectSingleArgYieldsCorrectOutput2(){
		Main.main(studentIDsArg);
		assertEquals("111111\n111112\n111113\n111114\n111115\n111116\n111117\n111118\n111119\n111120\n111121\n111122\n111123\n111124\n111125\n111126\n111127\n111128\n111129\n111130\n111131\n111132\n111133\n111134\n111135\n111136\n111137\n111138\n111139\n111140\n111141\n111142\n111143\n111144\n111145\n111146\n111147\n111148\n111149\n111150\n111151\n111152\n111153\n111154\n111155\n111156\n111157\n111158\n111159\n111160\n111161\n111162\n111163\n111164\n111165\n111166\n111167\n111168\n111169\n111170\n111171\n111172\n111173\n111174\n111175\n111176\n111177\n111178\n111179\n111180\n111181\n111182\n111183\n111184\n111185\n111186\n111187\n111188\n111189\n111190\n111191\n111192\n111193\n111194\n111195\n111196\n111197\n111198\n111199\n111200\n111201\n111202\n111203\n111204\n111205\n111206\n111207\n111208\n111209\n111210\n111211\n111212\n111213\n111214\n111215\n111216\n111217\n111218\n111219\n111220\n111221\n111222\n111223\n111224\n111225\n111226\n111227\n111228\n111229\n111230\n111231\n111232\n111233\n111234\n111235\n111236\n111237\n111238\n111239\n111240\n111241\n111242\n111243\n111244\n111245\n111246\n111247\n111248\n111249\n111250\n111251\n111252\n111253\n111254\n111255\n111256\n111257\n111258\n111259\n111260\n111261\n111262\n111263\n111264\n111265\n111266\n111267\n111268\n111269\n111270\n111271\n111272\n111273\n111274\n111275\n111276\n111277\n111278\n111279\n111280\n111281\n111282\n111283\n111284\n111285\n111286\n111287\n111288\n111289\n111290\n111291\n111292\n111293\n111294\n111295\n111296\n111297\n111298\n111299\n111300\n111301\n111302\n111303\n111304\n111305\n111306\n111307\n111308\n111309\n111310\n111311\n111312\n111313\n111314\n111315\n111316\n111317\n111318\n111319\n111320\n111321\n111322\n111323\n111324\n111325\n111326\n111327\n111328\n111329\n111330\n111331\n111332\n111333\n111334\n111335\n111336\n111337\n111338\n111339\n111340\n111341\n111342\n111343\n111344\n111345\n111346\n111347\n111348\n111349\n111350\n111351\n111352\n111353\n111354\n111355\n111356\n111357\n111358\n111359\n111360\n111361\n111362\n111363\n111364\n111365\n111366\n111367\n111368\n111369\n111370\n111371\n111372\n111373\n111374\n111375\n111376\n111377\n111378\n111379\n111380\n111381\n111382\n111383\n111384\n111385\n111386\n111387\n111388\n111389\n111390\n111391\n111392\n111393\n111394\n111395\n111396\n111397\n111398\n111399\n111400\n111401\n111402\n111403\n111404\n111405\n111406\n111407\n111408\n111409\n111410",
		out.toString().trim());
	}
	
	@Test
	public void testIncorrectSingleArgDoesNothing(){
		String[] arg = {"stuff"};
		Main.main(arg);
		
		assertEquals("",out.toString());
	}
	
	@Test
	public void testWindowOpensOnRuntime(){
		Database testDatabase = new Database();
		boolean windowOpened = false;
		String[] arg = {};
		Main.main(arg);
		try{
			JFrame testWindow = new GUI(testDatabase);
			testWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			testWindow.setSize(new Dimension(300,300));
			testWindow.setResizable(false);
			testWindow.setVisible(true);
			windowOpened = true;
		}
		catch(IOException e){}

		assertTrue(windowOpened);
	}	
	
}