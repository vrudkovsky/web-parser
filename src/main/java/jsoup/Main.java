package jsoup;

import jsoup.OgogoroNewsListener;

public class Main {

	public static void main(String[] args) throws Exception{
		final OgogoroNewsListener ogogoroNewsListener = new OgogoroNewsListener("wss://ogogoro.com/ogogoro");
		ogogoroNewsListener.connect();
	}
}
