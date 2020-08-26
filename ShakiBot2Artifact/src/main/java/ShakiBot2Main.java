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
          		api.setGame("서버따윈 없기 때문에 만든놈이 컴끄면 꺼지는 리얼한 샤키봇"); 
          		
                 api.registerListener(new MessageCreateListener() {
                      public void onMessageCreate(DiscordAPI api, Message message) {
                    	  ScriptEngineManager mgr = new ScriptEngineManager();
                    	  ScriptEngine engine = mgr.getEngineByName("JavaScript");
                    	  String m = message.getContent();
                    	  EmbedBuilder embed = new EmbedBuilder();
                    	
                    	  if(m.contains("시발") || m.contains("개새끼") || m.contains("썅") || m.contains("병신") || m.contains("야발"))
                    		  message.reply("아 욕하지마요");
                    	  if(( m.startsWith("샤키야") ) || m.startsWith("수진아") || m.startsWith("참수진")){
                    	      int roll, cka;
                    	      String msg;
                    	      
                    	      roll = (int)(Math.random()*4);
                    	      cka = (int)(Math.random()*9);
                    	      
                    	      //예시) 샤키야 배워 넘어져:쿠당탕
                    	      if(m. contains("배워")) {
                    	    	  try {
	                    	          BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\user\\Desktop\\자잘한거\\디코봇\\샤키봇2\\CustomCommand.txt", true) );
	                    	          final PrintWriter pw = new PrintWriter( bw, true );
	                    	          
	                    	    	  msg = m.replace("샤키야 배워 ", "");
	                    	     	  if( msg.contains(":") ) {
	    	                   	    	  String path = "C:\\Users\\user\\Desktop\\자잘한거\\디코봇\\샤키봇2\\CustomCommand.txt";
	    	                   	    	  BufferedReader br = new BufferedReader(new FileReader(path));
	    	                  	    	  String buff;
	    	                   	    	  boolean isAlready = false;
	    	                   	    	  
	    	                   	    	  while( ( buff = br.readLine() ) != null )
	    	                   	    		  if( buff.equals( msg ) )
	    	                   	    			  isAlready = true;
	    	                   	    	  
	    	                   	    	  if( isAlready == true )
	    	                   	    		  message.reply("아니 이미 있거든요,,?");
	    	                   	    	  else {
		                    	    		  pw.write( msg + "\n" );
		                    	    		  pw.flush();
		                    	    		  message.reply("아니 내가 왜,,,");
		                    	    		  pw.close();
	    	                   	    	  }
	                    	    	  } else
	                    	    		  message.reply("명령어 제대로 입력해줘요,,,");
                    	    	  } catch (Exception e) { e.printStackTrace(); }
                    	      }
                    	      else if(m.contains("계산")) {
	                              try {
	                            	  String exp; 
	                            	  
	                            	  exp = m.replace("샤키야 계산 ", "");
									message.reply( exp + "의 계산 결과는 " + engine.eval(exp) + ",,,,!" );
								} catch (ScriptException e) { e.printStackTrace(); }
                    	      }
                    	      else if(m.contains("날씨")) {
                    	    	  embed.setColor( Color.CYAN  );
                    	    	  embed.setTitle("오늘의 날씨");
                    	    	  embed.setDescription("오늘 " + "지역 이름" + "의 날씨는 전체적으로 " + "\"날씨\"" + " 입니다.");
                    	    	  embed.addField("최고/최저 기온", "오늘 " + "지역 이름" + "의 최저기온은 " + "온도 " + "이며,\n" + "최저기온은 " + "온도 " + "입니다." , false);
                    	    	  embed.addField("미세먼지", "오늘 " + "지역 이름" + "의 미세먼지 수치는" + "좋음/보통/나쁨" + "입니다.", false);
                    	    	  message.reply("", embed);
                    	      }
                    	      else if(m. contains("경윤이"))
    	                          message.reply("아잉 멀라잉,,,,,");//by 최지우
    	                      else if(m.contains("방송"))
    	                         message.reply("아잉 부끄렁//");//by 최지우 2
                    	      else if(m.contains("굴러")) {
                    	    	if( roll == 1 )
                    	    		message.reply("데구르르 데굴");
                    	    	else if( roll == 2 )
                    	    		message.reply("쾅 데구르르");
                    	    	else if( roll == 3 )
                    	    		message.reply("데구르르 댕강");
                    	      }
                    	      else if(m.contains("안녕"))
                    	    	  message.reply("뒤져");
                    	      else if(m.contains("참")) {
                    	    	  if( cka == 1  )
                    	    		  message.reply("사랑한방병원");
                    	    	  else if( cka == 2 )
                    	    		  message.reply("크래커");
                    	    	  else if( cka == 3 )
                    	    		  message.reply("깨스틱");
                    	    	  else if( cka == 4 )
                    	    		  message.reply("깨라면");
                    	    	  else if( cka == 5 )
                    	    		  message.reply("참참");
                    	    	  else if( cka == 6 )
                    	    		  message.reply("나무");
                    	    	  else if( cka == 7 )
                    	    		  message.reply("교육");
                    	    	  else if( cka == 8 )
                    	    		  message.reply("치");
                    	      }
                    	      else if(m.contains("졸려"))
	                              message.reply("아 자러 가시던가요,,");
                    	      else if(m.contains("일해"))
	                              message.reply("아니 일하고 있잖아요,,,,,");
                    	      else if(m.contains("달려"))
	                              message.reply("다다다다 쾅");
                    	      else if(m.contains("퓨브"))
	                              message.reply("<@682556804927979523>");
                    	      else if(m.contains("사랑해"))
	                              message.reply("샤키가 다른 누군가일겨\n" + 
	                            		  						"샤키는 세상에 많아((끄덕");//by 이경윤
                    	      else if(m.contains("자폭해")) {
	                              message.reply("펑");
	                              api.disconnect();
                    	      }
                    	      else if( m.contains("회의해?") ) {
                    	    	  message.reply("안해");
                    	      }
                    	      else if(m.contains("명령어") || m.contains("도움말") || m.contains("알려줘")) {
                    	    	  embed.setColor( Color.GREEN );
                    	    	  embed.setTitle("샤키봇의 표절작 샤키봇2");
                    	    	  embed.setDescription("원조 샤키봇과 같이 \"샤키야 명령어\" 로 소환합니다.\n천천히 원조 샤키봇을 표절해나갈 예정입니다.");
                    	    	  embed.addField("샤키야 계산 (식)", "식을 입력하면 샤키가 계산해줍니다.\n", false);
                    	    	  embed.addField("커스텀 명령어", "샤키야 배워 명령어:반응 으로 입력하면 샤키가 배웁니다.\n아직 잊는 건 없기 때문에 말하면 대신 지워드립니다.\n만든놈이 빡통이라 아직 오류가 많은 커맨드입니다.", false);
                    	    	  embed.setFooter("※샤키봇2는 서버 따위는 가지고 있지 않아서 만든놈이 컴 끄면 꺼집니다.※");
                    	    	  message.reply("", embed);
                    	      }
                    	      else {
                    	    	  try {
	                    	    	  String path = "C:\\Users\\user\\Desktop\\자잘한거\\디코봇\\"
	                    	    	  		+ "샤키봇2\\CustomCommand.txt";
	                    	    	  BufferedReader br = new BufferedReader(new FileReader(path));
	                    	    	  String buff;
	                    	    	  String[] splitedArr;
	                    	    	  List list = new List();
	                    	    	  int cnt=0, rep;
	                    	    	  
	                    	    	  while( ( buff = br.readLine() ) != null ) {
	                    	    		  splitedArr = buff.split(":");
	                    	    		  if( splitedArr[0].equals( m.replace("샤키야 ", "") ) ) {
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
                    		  message.reply("아니 한글로 하세요,,");
                    	  if(m.equals("지옥에서 돌아온 샤키야 굴러"))
                    		  message.reply("데구르르 데굴,,,,,?");
                      }
                  });
              }
             
 
              public void onFailure(Throwable t) {
                t.printStackTrace();
              }
            });
    }
}