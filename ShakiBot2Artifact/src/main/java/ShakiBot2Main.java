import java.awt.Color;
import java.awt.List;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import com.google.common.util.concurrent.FutureCallback;
 
import de.btobastian.javacord.DiscordAPI;
import de.btobastian.javacord.Javacord;
import de.btobastian.javacord.entities.message.Message;
import de.btobastian.javacord.entities.message.embed.EmbedBuilder;
import de.btobastian.javacord.listener.message.MessageCreateListener;
 
public class ShakiBot2Main {
    static public void main(String args[]) throws IOException{
        DiscordAPI api = Javacord.getApi("NzE5ODU2NTQyODE1MzU0OTEw.Xt9gzg.KPs6_aZkGhDFgZO1-DU-qb0hLOo", true);
        Weather wtr = new Weather();
        
        api.connect(new FutureCallback<DiscordAPI>() {
        	
              public void onSuccess(final DiscordAPI api) {
          		api.setGame("�������� ���� ������ ������� �Ĳ��� ������ ������ ��Ű��"); 
          		
                 api.registerListener(new MessageCreateListener() {
                      public void onMessageCreate(DiscordAPI api, Message message) {
                    	  ScriptEngineManager mgr = new ScriptEngineManager();
                    	  ScriptEngine engine = mgr.getEngineByName("JavaScript");
                    	  String m = message.getContent();
                    	  EmbedBuilder embed = new EmbedBuilder();
                    	
                    	  if(m.contains("�ù�") || m.contains("������") || m.contains("��") || m.contains("����") || m.contains("�߹�"))
                    		  message.reply("�� ����������");
                    	  if(( m.startsWith("��Ű��") ) || m.startsWith("������") || m.startsWith("������")){
                    	      int roll, cka;
                    	      String msg;
                    	      
                    	      roll = (int)(Math.random()*4);
                    	      cka = (int)(Math.random()*9);
                    	      
                    	      //����) ��Ű�� ��� �Ѿ���:�����
                    	      if(m. contains("���")) {
                    	    	  try {
	                    	          BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\user\\Desktop\\�����Ѱ�\\���ں�\\��Ű��2\\CustomCommand.txt", true) );
	                    	          final PrintWriter pw = new PrintWriter( bw, true );
	                    	          
	                    	    	  msg = m.replace("��Ű�� ��� ", "");
	                    	     	  if( msg.contains(":") ) {
	    	                   	    	  String path = "C:\\Users\\user\\Desktop\\�����Ѱ�\\���ں�\\��Ű��2\\CustomCommand.txt";
	    	                   	    	  BufferedReader br = new BufferedReader(new FileReader(path));
	    	                  	    	  String buff;
	    	                   	    	  boolean isAlready = false;
	    	                   	    	  
	    	                   	    	  while( ( buff = br.readLine() ) != null )
	    	                   	    		  if( buff.equals( msg ) )
	    	                   	    			  isAlready = true;
	    	                   	    	  
	    	                   	    	  if( isAlready == true )
	    	                   	    		  message.reply("�ƴ� �̹� �ְŵ��,,?");
	    	                   	    	  else {
		                    	    		  pw.write( msg + "\n" );
		                    	    		  pw.flush();
		                    	    		  message.reply("�ƴ� ���� ��,,,");
		                    	    		  pw.close();
	    	                   	    	  }
	                    	    	  } else
	                    	    		  message.reply("��ɾ� ����� �Է������,,,");
                    	    	  } catch (Exception e) { e.printStackTrace(); }
                    	      }
                    	      else if(m.contains("���")) {
	                              try {
	                            	  String exp; 
	                            	  
	                            	  exp = m.replace("��Ű�� ��� ", "");
									message.reply( exp + "�� ��� ����� " + engine.eval(exp) + ",,,,!" );
								} catch (ScriptException e) { e.printStackTrace(); }
                    	      }
                    	      else if(m.contains("����")) {
                    	    	  embed.setColor( Color.CYAN  );
                    	    	  embed.setTitle("������ ����");
                    	    	  embed.setDescription("���� " + "���� �̸�" + "�� ������ ��ü������ " + "\"����\"" + " �Դϴ�.");
                    	    	  embed.addField("�ְ�/���� ���", "���� " + "���� �̸�" + "�� ��������� " + "�µ� " + "�̸�,\n" + "��������� " + "�µ� " + "�Դϴ�." , false);
                    	    	  embed.addField("�̼�����", "���� " + "���� �̸�" + "�� �̼����� ��ġ��" + "����/����/����" + "�Դϴ�.", false);
                    	    	  message.reply("", embed);
                    	      }
                    	      else if(m. contains("������"))
    	                          message.reply("���� �ֶ���,,,,,");//by ������
    	                      else if(m.contains("���"))
    	                         message.reply("���� �β���//");//by ������ 2
                    	      else if(m.contains("����")) {
                    	    	if( roll == 1 )
                    	    		message.reply("�������� ����");
                    	    	else if( roll == 2 )
                    	    		message.reply("�� ��������");
                    	    	else if( roll == 3 )
                    	    		message.reply("�������� ��");
                    	      }
                    	      else if(m.contains("�ȳ�"))
                    	    	  message.reply("����");
                    	      else if(m.contains("��")) {
                    	    	  if( cka == 1  )
                    	    		  message.reply("����ѹ溴��");
                    	    	  else if( cka == 2 )
                    	    		  message.reply("ũ��Ŀ");
                    	    	  else if( cka == 3 )
                    	    		  message.reply("����ƽ");
                    	    	  else if( cka == 4 )
                    	    		  message.reply("�����");
                    	    	  else if( cka == 5 )
                    	    		  message.reply("����");
                    	    	  else if( cka == 6 )
                    	    		  message.reply("����");
                    	    	  else if( cka == 7 )
                    	    		  message.reply("����");
                    	    	  else if( cka == 8 )
                    	    		  message.reply("ġ");
                    	      }
                    	      else if(m.contains("����"))
	                              message.reply("�� �ڷ� ���ô�����,,");
                    	      else if(m.contains("����"))
	                              message.reply("�ƴ� ���ϰ� ���ݾƿ�,,,,,");
                    	      else if(m.contains("�޷�"))
	                              message.reply("�ٴٴٴ� ��");
                    	      else if(m.contains("ǻ��"))
	                              message.reply("<@682556804927979523>");
                    	      else if(m.contains("�����"))
	                              message.reply("��Ű�� �ٸ� �������ϰ�\n" + 
	                            		  						"��Ű�� ���� ����((����");//by �̰���
                    	      else if(m.contains("������")) {
	                              message.reply("��");
	                              api.disconnect();
                    	      }
                    	      else if( m.contains("ȸ����?") ) {
                    	    	  message.reply("����");
                    	      }
                    	      else if(m.contains("��ɾ�") || m.contains("����") || m.contains("�˷���")) {
                    	    	  embed.setColor( Color.GREEN );
                    	    	  embed.setTitle("��Ű���� ǥ���� ��Ű��2");
                    	    	  embed.setDescription("���� ��Ű���� ���� \"��Ű�� ��ɾ�\" �� ��ȯ�մϴ�.\nõõ�� ���� ��Ű���� ǥ���س��� �����Դϴ�.");
                    	    	  embed.addField("��Ű�� ��� (��)", "���� �Է��ϸ� ��Ű�� ������ݴϴ�.\n", false);
                    	    	  embed.addField("Ŀ���� ��ɾ�", "��Ű�� ��� ��ɾ�:���� ���� �Է��ϸ� ��Ű�� ���ϴ�.\n���� �ش� �� ���� ������ ���ϸ� ��� �����帳�ϴ�.\n������� �����̶� ���� ������ ���� Ŀ�ǵ��Դϴ�.", false);
                    	    	  embed.setFooter("�ػ�Ű��2�� ���� ������ ������ ���� �ʾƼ� ������� �� ���� �����ϴ�.��");
                    	    	  message.reply("", embed);
                    	      }
                    	      else {
                    	    	  try {
	                    	    	  String path = "C:\\Users\\user\\Desktop\\�����Ѱ�\\���ں�\\"
	                    	    	  		+ "��Ű��2\\CustomCommand.txt";
	                    	    	  BufferedReader br = new BufferedReader(new FileReader(path));
	                    	    	  String buff;
	                    	    	  String[] splitedArr;
	                    	    	  List list = new List();
	                    	    	  int cnt=0, rep;
	                    	    	  
	                    	    	  while( ( buff = br.readLine() ) != null ) {
	                    	    		  splitedArr = buff.split(":");
	                    	    		  if( splitedArr[0].equals( m.replace("��Ű�� ", "") ) ) {
	                    	    			  list.add( splitedArr[1] );
	                    	    			  cnt++;
	                    	    		  }
	                    	    	  }
	                    	    	  rep = (int)(Math.random()*(cnt));
	                    	    	  message.reply( list.getItem(rep) );
	                    	    	  
                    	    	  } catch (Exception e) { e.printStackTrace(); }
                    	      }
                          }
                    	  if( m.equals("tizldi rnffj"))
                    		  message.reply("�ƴ� �ѱ۷� �ϼ���,,");
                    	  if(m.equals("�������� ���ƿ� ��Ű�� ����"))
                    		  message.reply("�������� ����,,,,,?");
                      }
                  });
              }
             
 
              public void onFailure(Throwable t) {
                t.printStackTrace();
              }
            });
    }
}