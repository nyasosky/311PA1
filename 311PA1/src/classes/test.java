package classes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class test {

	@Test
	void test1() {
		Intervals vals = new Intervals();
		vals.getList()[0][0] = 1;
		vals.getList()[0][1] = 3;
		vals.getList()[1][0] = 2;
		vals.getList()[1][1] = 5;
		vals.getList()[2][0] = 5;
		vals.getList()[2][1] = 7;
		vals.getList()[3][0] = 3;
		vals.getList()[3][1] = 8;
		vals.getList()[4][0] = 6;
		vals.getList()[4][1] = 7;
		
		for (int i = 0; i < vals.getList().length; i++) {
			System.out.println("Interval: {" + vals.getList()[i][0] + ", " + vals.getList()[i][1] + "}");
		}
		
		
		for (int i = 0; i < vals.getList().length; i++) {
			vals.intervalInsert(vals.getList()[i][0],vals.getList()[i][1]);
		}
		
		vals.getRBTree().InOrderTraversal(vals.getRBTree().getRoot());
	}
}


