import java.io.*;

public class Chip_star{
	public static void main(String arg[]){

		int ban,eat,chip=21,whi=1;
		System.out.println("chipstar��21������܂��B\n��U�A��U�͂����Ō��܂�܂��B\n�Ō��chip��H�ׂ��ق��̕����ł��B");

		ban = (int)(Math.random()*10) % 2;
		
		while(chip>0){
			//�Q�[�������݂ɍs���܂�//
			if(ban==0){
				System.out.println("\n�l�ނ̃^�[��");
				chip = human(chip);
				ban++;
			}else if( ban == 1 ){
				System.out.println("\nAI�̃^�[��");
				chip = kikai(chip);
				ban--;
			}else{
				System.out.println("�G���[");
				break;
			}
		}
		//���Ҕ��\//
		if( ban == 0 ){
			System.out.println("�l�ނ̏����ł�");
		}else if( ban == 1 ){
			System.out.println("AI�̏����ł�");
		}else{
			System.out.println("�G���[�ł�");
		}

	}
	
	//�l�ނ̐H�ׂ閇�������߂�֐�
	public static int human(int chip){
		int eat,flag=1;
		System.out.println("chip�̎c�薇��" + chip + "��\n�����H�ׂ܂����H(1�`3�̐�������͂��ĉ�����)");

		//���͎擾�̂��߂�
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		while( flag == 1 ){
			try{
				eat = Integer.parseInt( reader.readLine() );
				if(eat >= 1 && eat <= 3){
					chip -= eat;
					if( chip < 1)System.out.println("chip��0��");
					flag = 0;
				}else if( 0 >= eat || eat > 3){
					System.out.println("���͂�����������܂���\n������x���͂��ĉ�����");
				}
				
			}catch(IOException e){
				System.out.println(e);
			}catch(NumberFormatException e){
				System.out.println("���͂�����������܂���\n������x���͂��ĉ�����");
			}
		}
		return chip;		
	}
	
	//AI�̐H�ׂ閇�������߂�֐�
	public static int kikai(int chip){
	int eat, z = 0;
	
	//eat�͐H�ׂ�������//
	for(int i = 1; z < chip; i++ ){
		z = 4 * i + 1;
	}
	eat = ( 4 - ( z -  chip ));

	//human�������������ɂ₯�ɂȂ�AI�̂��߂̗���//
	if( eat == 4 || eat == 0){
		eat = ( (int)(Math.random()*10) % 3) + 1;
	}

	System.out.println( eat + "���H�ׂ�");
	chip -= eat;
	//�H�׎c���������Ԃ��Ă�//
	return chip;
	}	
}