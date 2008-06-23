package se.su.it.smack.pubsub.elements;

/**
 * Text Contenable element
 * 
 * @author Juan F. Codagnone
 * @since Jun 22, 2008
 */
public interface ContentableElement {

    void setContent(String content);
    
    String getContent();
}
