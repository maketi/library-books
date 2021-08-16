$(document).ready(() => {
    let bookToEdit = null;

    $('#add-book-button').click(() => {
        if (bookToEdit) {
            editBook(bookToEdit);
        } else {
            addNew();
        }
    });

    function editBook(bookToEdit) {

        const title = $('#modal-books-title').val();
        const author = $('#modal-books-author').val();
        const category = $('#modal-books-category').val();
        const amount = $('#modal-books-amount').val();
        const publisher = $('#modal-books-publisher').val();
        const year = $('#modal-books-year').val();
        const image = $('#modal-books-image').val();

        fetch(`/api/library/books/${bookToEdit}`, {
            method: 'PATCH',
            body: JSON.stringify({
                title: title,
                author: author,
                category: category,
                amount: amount,
                publisher: publisher,
                year: year,
                image: image
            }),
            headers: {
                'Content-Type': 'application/json'
            }
        }).then(response => {
            if (response.ok) {
                location.reload();
            } else {
                alert("Error" + response.status);
            }
        });
    }

    function addNew() {

        const title = $('#modal-books-title').val();
        const author = $('#modal-books-author').val();
        const category = $('#modal-books-category').val();
        const amount = $('#modal-books-amount').val();
        const publisher = $('#modal-books-publisher').val();
        const year = $('#modal-books-year').val();
        const image = $('#modal-books-image').val();

        fetch('/api/library/books', {
            method: 'POST',
            body: JSON.stringify({
                title: title,
                author: author,
                category: category,
                amount: amount,
                publisher: publisher,
                year: year,
                image: image
            }),
            headers: {
                'Content-Type': 'application/json'
            }
        }).then(response => {
            if (response.ok) {
                location.reload();
                clearModal();
            } else {
                alert("Error" + response.status);
            }
        });
    }

    function clearModal() {
        $('#modal-books-title').val('');
        $('#modal-books-author').val('');
        $('#modal-books-category').val('');
        $('#modal-books-amount').val('');
        $('#modal-books-publisher').val('');
        $('#modal-books-year').val('');
        $('#modal-books-image').val('');
    }

    $('.delete-icon').click(function () {
        const bookId = this.parentElement.id;
        fetch(`/api/library/books/${bookId}`, {
            method: 'DELETE'
        }).then(_response => location.reload());
    });

    $('.edit-icon').click(function () {
        bookToEdit = this.parentElement.id;
        const row = this.parentElement.parentElement.parentElement;
        const title = row.children[1].innerText;
        const author = row.children[2].innerText;
        const category = row.children[3].innerText;
        const amount = row.children[4].innerText
        const publisher = row.children[5].innerText;
        const year = row.children[6].innerText;
        const image = row.children[7].innerText;

        $('#modal-books-title').val(title);
        $('#modal-books-author').val(author);
        $('#modal-books-category').val(category);
        $('#modal-books-amount').val(amount);
        $('#modal-books-publisher').val(publisher);
        $('#modal-books-year').val(year);
        $('#modal-books-image').val(image);

    });

    $('#add-book-main-button').click(() => {
        clearModal();
        bookToEdit = null
    });
});