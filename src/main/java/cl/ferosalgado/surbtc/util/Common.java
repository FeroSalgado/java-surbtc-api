package cl.ferosalgado.surbtc.util;

import java.util.Date;

public class Common {

	public static String getNonce(){
		
		Long timeLong = (long) (new Date().getTime() * 1E6);
		
		return timeLong.toString();
	}
}
