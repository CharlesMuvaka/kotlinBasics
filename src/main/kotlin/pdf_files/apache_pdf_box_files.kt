/*
                                Apache PdfBox Library

      - contains classes that extensively extracts text from a document.


        val file = File("path/to/your/input.pdf")
        val document = PDDocument.load(file)

        // Extract text from the PDF
        val stripper = PDFTextStripper()
        val text = stripper.getText(document)

        println("Text in the PDF:")
        println(text)

        // Close the document
        document.close()


         // Create a new PDF document
            val document = PDDocument()

            // Add a blank page
            val page = PDPage()
            document.addPage(page)

            // Write some text to the page
            val contentStream = PDPageContentStream(document, page)
            contentStream.beginText()
            contentStream.setFont(PDType1Font.HELVETICA_BOLD, 12f)
            contentStream.newLineAtOffset(100f, 700f)
            contentStream.showText("Hello, PDFBox in Kotlin!")
            contentStream.endText()
            contentStream.close()

            // Save the document
            document.save("path/to/your/output.pdf")

            // Close the document
            document.close()
 */