package practice.bookShop.model;

    public class Book implements Comparable<Book> {

        protected int isbn;
        protected String autor;
        protected String name;
        protected int year;

        public Book(int isbn, String autor, String name, int year) {
            this.isbn = isbn;
            this.autor = autor;
            this.name = name;
            this.year = year;
        }

        public int getIsbn() {
            return isbn;
        }

        public void setIsbn(int isbn) {
            this.isbn = isbn;
        }

        public String getAutor() {
            return autor;
        }

        public void setAutor(String autor) {
            this.autor = autor;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getYear() {
            return year;
        }

        public void setYear(int year) {
            this.year = year;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Book book = (Book) o;
            return isbn == book.isbn;
        }

        @Override
        public int hashCode() {
            return isbn;
        }

        @Override
        public String toString() {
            return "Book{" +
                    "isbn=" + isbn +
                    ", autor='" + autor + '\'' +
                    ", name='" + name + '\'' +
                    ", year=" + year +
                    '}';
        }

        @Override
        public int compareTo(Book o) {
            return this.isbn-o.isbn;
        }
    }
