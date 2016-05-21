

public class Towers_of_Hanoi {
public static void towersOfHanoi(int n, int x, int y, int z) {
if (n % 2 == 1) {
tower1(n, x, y, z);// °ò¼Æ
} else {
tower2(n, x, y, z);// °¸¼Æ
}
}

public static void tower1(int n, int A, int B, int C) {
int n1 = n;
int tagA = n - 1;
int tagB = 0;
int tagC = 0;
int[] a = new int[n];
int[] b = new int[n];
int[] c = new int[n];
for (int i = 0; i < n; i++) {
a[i] = n1;
n1--;
}

while (true) {
if (a[tagA] < c[tagC]||c[tagC]==0) {
c[tagC] = a[tagA];
a[tagA] = 0;
tagA--;
tagC++;
System.out.println("Move top disk from tower " + A
+ " to top of tower " + B);
} else {
a[tagA] = c[tagC];
c[tagC] = 0;
tagC--;
tagA++;
System.out.println("Move top disk from tower " + B
+ " to top of tower " + A);
}
if (c[n - 1] == 1) {
break;
}
if (a[tagA] < b[tagB]||b[tagB]==0) {
b[tagB] = a[tagA];
a[tagA] = 0;
tagA--;
tagB++;
System.out.println("Move top disk from tower " + A
+ " to top of tower " + C);
} else {
a[tagA] = b[tagB];
b[tagB] = 0;
tagB--;
tagA++;
System.out.println("Move top disk from tower " + C
+ " to top of tower " + A);
}
if (b[tagB] < c[tagC]||c[tagC]==0) {
c[tagC] = b[tagB];
b[tagB] = 0;
tagB--;
tagC++;
System.out.println("Move top disk from tower " + C
+ " to top of tower " + B);
} else {
b[tagB] = c[tagC];
c[tagC] = 0;
tagC--;
tagB++;
System.out.println("Move top disk from tower " + B
+ " to top of tower " + C);
}
if (c[n - 1] == 1) {
break;
}
}
}

public static void tower2(int n, int A, int B, int C) {
int n1 = n;
int tagA = n - 1;
int tagB = 0;
int tagC = 0;
int[] a = new int[n];
int[] b = new int[n];
int[] c = new int[n];
for (int i = 0; i < n; i++) {
a[i] = n1;
n1--;
}
while (true) {
if (a[tagA] < b[tagB]||b[tagB]==0) {
b[tagB] = a[tagA];
a[tagA] = 0;
tagA--;
tagB++;
System.out.println("Move top disk from tower " + A
+ " to top of tower " + C);
} else {
a[tagA] = b[tagB];
b[tagB] = 0;
tagB--;
tagA++;
System.out.println("Move top disk from tower " + C
+ " to top of tower " + A);
}
if (a[tagA] < c[tagC]||c[tagC]==0) {
c[tagC] = a[tagA];
a[tagA] = 0;
tagA--;
tagC++;
System.out.println("Move top disk from tower " + A
+ " to top of tower " + B);
} else {
a[tagA] = c[tagC];
c[tagC] = 0;
tagC--;
tagA++;
System.out.println("Move top disk from tower " + B
+ " to top of tower " + A);
}
if (c[n - 1] == 1) {
break;
}
if (b[tagB] < c[tagC]||c[tagC]==0) {
c[tagC] = b[tagB];
b[tagB] = 0;
tagB--;
tagC++;
System.out.println("Move top disk from tower " + C
+ " to top of tower " + B);
} else {
b[tagB] = c[tagC];
c[tagC] = 0;
tagC--;
tagB++;
System.out.println("Move top disk from tower " + B
+ " to top of tower " + C);
}
if (c[n - 1] == 1) {
break;
}
}
}

public static void main(String[] args) {

System.out.println("Moves for a three disk problem are");
towersOfHanoi(1, 1, 2, 3);
System.out.println("-------------------------------------------");
towersOfHanoi(3, 1, 2, 3);
}
}