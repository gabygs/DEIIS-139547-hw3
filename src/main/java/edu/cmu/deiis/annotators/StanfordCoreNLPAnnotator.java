package edu.cmu.deiis.annotators;
/**
 * code based on reference:
 *  https://code.google.com/p/cleartk/source/browse/cleartk-stanford-corenlp/src/main/java/org/cleartk/stanford/StanfordCoreNLPAnnotator.java?spec=svn87f3ecca8547adf0bbac0a8495822ac3601603bf&r=87f3ecca8547adf0bbac0a8495822ac3601603bf
 */

import java.util.Properties;

import org.apache.uima.UimaContext;
import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;
import org.apache.uima.resource.ResourceInitializationException;

import edu.stanford.nlp.ling.CoreAnnotations.CharacterOffsetBeginAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.CharacterOffsetEndAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.LemmaAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.NamedEntityTagAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.PartOfSpeechAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.SentencesAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.TokensAnnotation;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.util.CoreMap;

import edu.cmu.deiis.types.NamedEntity;
import edu.cmu.deiis.types.Sentence;
import edu.cmu.deiis.types.Token;


public class StanfordCoreNLPAnnotator extends JCasAnnotator_ImplBase {
	private StanfordCoreNLP nlpProcess;
	
	public void initialize(UimaContext aContext) throws ResourceInitializationException {
		//initialization, with my options
		super.initialize(aContext);
		Properties props = new Properties();
		props.put("annotators", "tokenize, ssplit, pos, lemma, ner");
		nlpProcess = new StanfordCoreNLP(props);
		}
	
	@Override
	public void process(JCas aJCas) throws AnalysisEngineProcessException {
		String preNe = "";
		int neBegin = 0;
		int neEnd = 0;
		
		//get Document
		String documentText = aJCas.getDocumentText();
		//turn it into an annotation
		Annotation document = new Annotation(documentText);
		nlpProcess.annotate(document);
		
		// Iterate the "Stanford sentences" i.e. sentences annotated by StanfordCoreNLP
		for (CoreMap sentenceAnn : document.get(SentencesAnnotation.class)) {
			int sentBegin = sentenceAnn.get(CharacterOffsetBeginAnnotation.class);
			int sentEnd = sentenceAnn.get(CharacterOffsetEndAnnotation.class);
			
			Sentence sSent = new Sentence(aJCas, sentBegin, sentEnd);
			sSent.addToIndexes();
			
			// Now we need to iterate through the tokens (from each of the sentences previously obtained).
			for (CoreLabel tokenAnn : sentenceAnn.get(TokensAnnotation.class)) {
				int beginIndex = tokenAnn.get(CharacterOffsetBeginAnnotation.class);
				int endIndex = tokenAnn.get(CharacterOffsetEndAnnotation.class);

				Token sToken = new Token(aJCas, beginIndex, endIndex);

				sToken.setPOS(tokenAnn.get(PartOfSpeechAnnotation.class));
				sToken.setLemma(tokenAnn.get(LemmaAnnotation.class));
				sToken.setNamedEntity(tokenAnn.get(NamedEntityTagAnnotation.class));
				sToken.addToIndexes(aJCas);

				// handling named entities
				/*String  namedEntity = tokenAnn.get(NamedEntityTagAnnotation.class);
				if (namedEntity != null) {
					if (namedEntity.equals(preNe) && !preNe.equals("")) {
					} else if (preNe.equals("")) {
						neBegin = beginIndex;
						preNe = namedEntity;
					} else {
						if (!preNe.equals("O")) {
							NamedEntity nameEnt = new NamedEntity(aJCas);
							nameEnt.setBegin(neBegin);
							nameEnt.setEnd(neEnd);
							nameEnt.setEntityType(preNe);
							nameEnt.addToIndexes(aJCas);
						}
						neBegin = beginIndex;
						preNe = namedEntity;
					}
					neEnd = endIndex;
				}*/
			}
		}
	}
}