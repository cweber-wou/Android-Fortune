package com.test;
import java.util.*;
public class FORTUNE {
	private LinkedList <String>noun;
	private LinkedList <String>adverb;
	private LinkedList <String>verb;
	private LinkedList <String>adjective;
	private Random r;
	
	private void SetupNoun()
	{
		noun= new LinkedList<String>();
		noun.add("Brother");
		noun.add("Sister");
		noun.add("Profesor");
		noun.add("Mother");
		noun.add("Father");
		noun.add("Cat");
		noun.add("Dog");
		noun.add("Bird");
		noun.add("Car");
		noun.add("Computer");
		noun.add("Phone");
		noun.add("Windows");
		noun.add("Unix");
	}
	
	private void SetupAdverb()
	{
		adverb= new LinkedList<String>();
		adverb.add("carefully");
		adverb.add("correctly");
		adverb.add("eagerly");
		adverb.add("easily");
		adverb.add("fast");
		adverb.add("loudly");
		adverb.add("patiently");
		adverb.add("quickly");
		adverb.add("quietly");
		adverb.add("underground");
		adverb.add("abroad");
		adverb.add("anywhere");
		adverb.add("downstairs");
		adverb.add("here");
		adverb.add("home");
		adverb.add("nowhere");
		adverb.add("outside");
		adverb.add("upstairs");
		adverb.add("somewhere");
		adverb.add("accidentally");
		adverb.add("intentionally");
	}
	
	private void SetupVerb()
	{
		verb= new LinkedList<String>();
		verb.add("add");
		verb.add("admire");
		verb.add("analyse");
		verb.add("appear");
		verb.add("alert");
		verb.add("arrange");
		verb.add("attach");
		verb.add("back");
		verb.add("behave");
		verb.add("bleach");
		verb.add("bare");
		verb.add("boil");
		verb.add("bruise");
		verb.add("brush");
		verb.add("calculate");
		verb.add("choke");
		verb.add("compare");
		verb.add("cheat");
		verb.add("dam");
		verb.add("depend");
		verb.add("discover");
		verb.add("drop");
		verb.add("embarrass");
		verb.add("exercise");
		verb.add("fancy");
		verb.add("flower");
		verb.add("gaze");
		verb.add("guarantee");
		verb.add("harm");
		verb.add("hop");
		verb.add("inject");
		verb.add("interrupt");
		verb.add("interest");
		verb.add("join");
		verb.add("judge");
		verb.add("kiss");
		verb.add("kill");
		verb.add("license");
		verb.add("listen");
		verb.add("matter");
		verb.add("measure");
		verb.add("multiply");
		verb.add("need");
		verb.add("permit");
		verb.add("peel");
		verb.add("remember");
		
	}
	private void SetupAdjective()
	{
		adjective= new LinkedList<String>();
		adjective.add("yellow");
		adjective.add("red");
		adjective.add("orange");
		adjective.add("green");
		adjective.add("blue");
		adjective.add("purple");
		adjective.add("gray");
		adjective.add("black");
		adjective.add("white");
		adjective.add("adorable");
		adjective.add("handsome");
		adjective.add("glamorous");
		adjective.add("plain");
		adjective.add("angry");
		adjective.add("jealous");
		adjective.add("inexpensive");
		adjective.add("powerful");
		adjective.add("shy");
		adjective.add("agreeable");
		adjective.add("faithful");
		adjective.add("happy");
		adjective.add("obedient");
		adjective.add("victorious");
		adjective.add("crooked");
		adjective.add("round");
		adjective.add("skinny");
		adjective.add("colossal");
		adjective.add("immense");
		adjective.add("miniature");
		adjective.add("teeny");
		adjective.add("cooing");
		adjective.add("hissing");
		adjective.add("purring");
		adjective.add("thundering");
		adjective.add("voiceless");
		adjective.add("quick");
		adjective.add("slow");
		adjective.add("greasy");
		adjective.add("sweet");
		adjective.add("broken");
		adjective.add("crooked");
		adjective.add("damaged");
		adjective.add("freezing");
		adjective.add("abundant");
		adjective.add("numerous");
	}

	public FORTUNE() {

		SetupNoun();
		SetupAdjective();
		SetupVerb();
		SetupAdverb();
		r=new Random();
		
	}
	
	private String getNoun(){
		int size=noun.size();
		int x = r.nextInt(size);
		String out = noun.get(x);
		return out;
	}
	private String getAdjective(){
		int size=adjective.size();
		int x = r.nextInt(size);
		String out = adjective.get(x);
		return out;
	}
	private String getVerb(){
		int size=verb.size();
		int x = r.nextInt(size);
		String out = verb.get(x);
		return out;
	}
	private String getAdverb(){
		int size=adverb.size();
		int x = r.nextInt(size);
		String out = adverb.get(x);
		return out;
	}
	
	public String get() {
		String out="";
		out+=getNoun()+ " is "+ getVerb() + " " + getAdverb() + " the " + getAdjective() + " " + getNoun() + ".";
		return out;
	}
	
	public static void main(String [] args)
	{
		FORTUNE f = new FORTUNE();
		System.out.println(f.get());
		System.out.println(f.get());
		System.out.println(f.get());
		System.out.println(f.get());
		System.out.println(f.get());
		System.out.println(f.get());
		System.out.println(f.get());
		System.out.println(f.get());
		System.out.println(f.get());
		System.out.println(f.get());
		System.out.println(f.get());
		System.out.println(f.get());
		System.out.println(f.get());
		System.out.println(f.get());
		System.out.println(f.get());
		System.out.println(f.get());
	
	}
	
}
