
public class mainClass {

	public static void main(String[] args) {

		int[] tab = {};

		int[] tab2 = new int[tab.length];
		int X = 20;
		double moyenne = 0.0;

		for (int i = 0; i < X; i++) {
			long startTime = System.nanoTime();
			tab2 = trierCorentin(tab);
			long endTime = System.nanoTime();
			moyenne += endTime - startTime;
			System.out.print((endTime - startTime)  + " ms, ");
		}
		moyenne /= X;
		System.out.println("\n=>Tri Corentin\nTableau de longueur : " + tab.length);
		System.out.println("Moyenne : " + moyenne  + " ms\n");
		
		for (int i = 0; i < X; i++) {
			long startTime = System.nanoTime();
			tab2 = trierJA(tab);
			long endTime = System.nanoTime();
			moyenne += endTime - startTime;
			System.out.print((endTime - startTime)  + " ms, ");
		}
		moyenne /= X;
		System.out.println("\n=>Tri Jean Alexandre\nTableau de longueur : " + tab.length);
		System.out.println("Moyenne : " + moyenne  + " ms\n\n\n");
		
		for (int i = 0; i < X; i++) {
			long startTime = System.nanoTime();
			tab2 = trierRamy(tab);
			long endTime = System.nanoTime();
			moyenne += endTime - startTime;
			System.out.print((endTime - startTime)  + " ms, ");
		}
		moyenne /= X;
		System.out.println("\n=>Tri Ramy\nTableau de longueur : " + tab.length);
		System.out.println("Moyenne : " + moyenne  + " ms\n\n\n");

		
		for(int t : tab2){
			System.out.print(t+ ", ");
		}
	}

	public static int[] trierCorentin(int[] tabToSort) {
		int length = tabToSort.length;
		int[] sortedTab = new int[length];
		int i = 0, count = 0;

		while (i < length) {
			for (int t : tabToSort) {
				if (t < tabToSort[i])
					count++;
			}
			for (int j = 0; j < i; j++) {
				if (tabToSort[i] == tabToSort[j])
					count++;
			}

			sortedTab[count] = tabToSort[i];
			i++;
			count = 0;
		}
		return sortedTab;
	}
	
	public static int[] trierJA(int[] tabToSort) {
		int length = tabToSort.length;
		int[] sortedTab = new int[length];
		int i = 0, count = 0;

		while (i < length) {
			for (int j = 0; j < i; j++) {
				if (tabToSort[i] == tabToSort[j])
					count++;
				if (tabToSort[i] > tabToSort[j])
					count++;
			}
			for (int j = i+1; j < length; j++) {
				if (tabToSort[i] > tabToSort[j])
					count++;
			}

			sortedTab[count] = tabToSort[i];
			i++;
			count = 0;
		}
		return sortedTab;
	}
	
	public static int[] trierRamy(int[] tabToSort) {
		int length = tabToSort.length;
		int[] sortedTab = new int[length];
		int count = 0;

		for(int i=0 ; i<length ; i++) {
			count=0;
			for(int j=0 ; j<length ; j++){
				if(tabToSort[j]<tabToSort[i])
					count++;
				if(tabToSort[j]==tabToSort[i] && j<i)
					count++;
			}
			
	
			sortedTab[count] = tabToSort[i];
		}
		return sortedTab;
	}

}
