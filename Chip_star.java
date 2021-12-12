import java.io.*;

public class Chip_star{
	public static void main(String arg[]){

		int ban,eat,chip=21,whi=1;
		System.out.println("chipstarが21枚あります。\n先攻、後攻はくじで決まります。\n最後のchipを食べたほうの負けです。");

		ban = (int)(Math.random()*10) % 2;
		
		while(chip>0){
			//ゲームを交互に行います//
			if(ban==0){
				System.out.println("\n人類のターン");
				chip = human(chip);
				ban++;
			}else if( ban == 1 ){
				System.out.println("\nAIのターン");
				chip = kikai(chip);
				ban--;
			}else{
				System.out.println("エラー");
				break;
			}
		}
		//勝者発表//
		if( ban == 0 ){
			System.out.println("人類の勝利です");
		}else if( ban == 1 ){
			System.out.println("AIの勝利です");
		}else{
			System.out.println("エラーです");
		}

	}
	
	//人類の食べる枚数を決める関数
	public static int human(int chip){
		int eat,flag=1;
		System.out.println("chipの残り枚数" + chip + "枚\n何枚食べますか？(1～3の整数を入力して下さい)");

		//入力取得のための
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		while( flag == 1 ){
			try{
				eat = Integer.parseInt( reader.readLine() );
				if(eat >= 1 && eat <= 3){
					chip -= eat;
					if( chip < 1)System.out.println("chipは0枚");
					flag = 0;
				}else if( 0 >= eat || eat > 3){
					System.out.println("入力が正しくありません\nもう一度入力して下さい");
				}
				
			}catch(IOException e){
				System.out.println(e);
			}catch(NumberFormatException e){
				System.out.println("入力が正しくありません\nもう一度入力して下さい");
			}
		}
		return chip;		
	}
	
	//AIの食べる枚数を決める関数
	public static int kikai(int chip){
	int eat, z = 0;
	
	//eatは食べたい枚数//
	for(int i = 1; z < chip; i++ ){
		z = 4 * i + 1;
	}
	eat = ( 4 - ( z -  chip ));

	//humanが強かった時にやけになるAIのための乱数//
	if( eat == 4 || eat == 0){
		eat = ( (int)(Math.random()*10) % 3) + 1;
	}

	System.out.println( eat + "枚食べた");
	chip -= eat;
	//食べ残した枚数返してる//
	return chip;
	}	
}