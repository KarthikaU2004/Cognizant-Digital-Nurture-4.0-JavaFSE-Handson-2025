public class FactoryMethodExample {
    interface Document {
        void open();
    }
    static class WordDocument implements Document {
        public void open() {
            System.out.println(" [Word]    : Word document opened successfully.");
        }
    }
    static class PdfDocument implements Document {
        public void open() {
            System.out.println(" [PDF]     : PDF document opened successfully.");
        }
    }
    static class ExcelDocument implements Document {
        public void open() {
            System.out.println(" [Excel]   : Excel spreadsheet opened successfully.");
        }
    }
    abstract static class DocumentFactory {
        public abstract Document createDocument();
    }
    static class WordFactory extends DocumentFactory {
        public Document createDocument() {
            return new WordDocument();
        }
    }
    static class PdfFactory extends DocumentFactory {
        public Document createDocument() {
            return new PdfDocument();
        }
    }
    static class ExcelFactory extends DocumentFactory {
        public Document createDocument() {
            return new ExcelDocument();
        }
    }
    public static void main(String[] args) {
        System.out.println("========= Document Management System =========\n");

        DocumentFactory wordFactory = new WordFactory();
        Document wordDoc = wordFactory.createDocument();
        wordDoc.open();

        DocumentFactory pdfFactory = new PdfFactory();
        Document pdfDoc = pdfFactory.createDocument();
        pdfDoc.open();

        DocumentFactory excelFactory = new ExcelFactory();
        Document excelDoc = excelFactory.createDocument();
        excelDoc.open();

        System.out.println("\n All documents opened successfully using Factory Method Pattern.");
    }
}
