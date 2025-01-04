package Factory;

public class DocumentFactory {
    
    public static Document createDocument(String type) {
        
        switch (type.toLowerCase()) {
            case "pdf":
                return new PDFDocument();
            case "word":
                return new WordDocument();
            case "html":
                return new HTMLDocument();
            default:
                throw new IllegalArgumentException("Unknown document type: " + type);
        }
    }
}