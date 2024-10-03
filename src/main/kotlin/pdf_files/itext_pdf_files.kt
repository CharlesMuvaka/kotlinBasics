/*
                            Pdf files
      - Like java, kotlin uses:
                       1. iText
                       2. Apache PdfBox
                                        to read and write pdf files.
      - To add their dependencies you can use Maven or gradle
      -For Maven
           1. iText dependency

          <dependency>
            <groupId>com.itextpdf</groupId>
            <artifactId>itext7-core</artifactId>
            <version>7.2.5</version>
          </dependency>

           2. Apache PdfBox dependency

            <dependency>
                <groupId>org.apache.pdfbox</groupId>
                <artifactId>pdfbox</artifactId>
                <version>2.0.28</version>
            </dependency>


      - For Gradle:
             1. iText dependency
                implementation("com.itextpdf:itext7-core:7.2.5")

             2. Apache PdfBox dependency
                implementation("org.apache.pdfbox:pdfbox:2.0.28")

      Key Libraries:
                    iText: Excellent for creating and manipulating PDFs, with a lot of features like form filling, encryption, etc.
                    Apache PDFBox: Great for reading, creating, and modifying PDF files, with extensive functionality for extracting text and working with PDFs.

                        iText
        - It contains classes availble for reading and writing pdf files
        - Reading the files, we

            1. PdfReader
                - This class is used to locate the document being read or written.
                - Remember to use try and catch block just incase the file is not there or doesn't contain the required format
            2. PdfDocument
                - This gets the document from the PdfReader for manipulation
                - It contains methods to read and write the document from


                val pdfReader = PdfReader("path/to/your/input.pdf")
                val pdfDocument = PdfDocument(pdfReader)

               -- Methods Involved --

              1. numberOfPages - Used to get the total number of pages present in the document.

                    // Read the number of pages
                        val numberOfPages = pdfDocument.numberOfPages
                        println("Number of pages in the PDF: $numberOfPages")

              2. getPage() - Used to get a page at a specified index
                           - The method accepts an integer argument specifying the page's index.

              3. extractContentAsText()
                                        - This method is used to extract content from the document as text.
                                        - The method must be accompanied by the getPage method to be exact on which page we are extracting content from.

                        // Extract content from the first page
                            val pageContent = pdfDocument.getPage(1).extractContentAsText()
                            println("Content from the first page: $pageContent")


 */