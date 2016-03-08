import java.lang.InterruptedException;

public class VenderLamp{
  // 0 (1) 2 (3) 4 (5) 6
  static char[][] viewTable = {
    {'+','+','+','+','+','+','+'},
    {'+',' ',' ',' ',' ',' ','+'},
    {'+',' ','+',' ','+',' ','+'},
    {'+',' ',' ',' ',' ',' ','+'},
    {'+',' ','+',' ','+',' ','+'},
    {'+',' ',' ',' ',' ',' ','+'},
    {'+','+','+','+','+','+','+'}
  };

  static int[] array_trans = {1,2,3};

  final static char o = '*';

  public static void main(String[] args){
    int p = 0;
    int cp = 0;
    for(int is=0;is<20;is++){
      if(cp >= 4){
        put(1,1,o);
        cp = 0;
      }else{
        if(p > 3) p=0;
      	outline(p);
      	if(p == 1 || p == 3) cp++;
      	if(cp < 4) p++;
      }
      try{
      	show();
        Thread.sleep(100);
      }catch(InterruptedException e){}
      clear();
    }
  }

  public static void outline(int p){
    switch(p){
      case 0:
        put(0,0,o);
        put(2,2,o);
        break;
      case 1:
        put(1,0,o);
        put(1,2,o);
        break;
      case 2:
        put(2,0,o);
        put(0,2,o);
        break;
      case 3:
        put(2,1,o);
        put(0,1,o);
        break;
    }
  }


  public static void clear(){
    for(int i=0;i<array_trans.length;i++){
      for(int j=0;j<array_trans.length;j++){
        put(i,j,' ');
      }
    }
  }

  public static void put(int x,int y,char w){
    if(x > viewTable.length || y > viewTable[0].length) return;
    viewTable[trans(x)][trans(y)] = w;
  }

  public static int trans(int i){
    return i + array_trans[i];
  }

  public static void show(){
  	for(char[] stra:viewTable){
  		for(char str:stra){
  			System.out.print(str);
  		}
  		System.out.println();
  	}
  }
}