import axios from '../custom-axios/axios';

const Library = {
    fetchAuthors: () => {
        return axios.get("/authors");
    },
    fetchCategories: () => {
        return axios.get("/categories");
    },
    fetchCountries: () => {
        return axios.get("/countries");
    },
    fetchBooks: () => {
        return axios.get("/books");
    },
    deleteBook: (id) => {
        return axios.post(`/delete/${id}`);
    },
    addBook: (name, author, category, availableCopies) => {
        return axios.post("/books/add", {
            "name" : name,
            "category":category,
            "author":author,
            "availableCopies" : availableCopies
        });
    },
    editBook: (id, name, author, category, availableCopies) => {
        return axios.post(`/edit/${id}`, {
            "name" : name,
            "category":category,
            "author":author,
            "availableCopies" : availableCopies
        });
    },
    markAsTakenBook:(id)=>{
        return axios.put(`/markAsTaken/${id}`);
    },
    returnBook:(id)=>{
        return axios.put(`/returnBook/${id}`)
    },
    getBook: (id) => {
        return axios.get(`/get/${id}`);
    }
}

export default Library;
