$(document).ready(() => {
    let readerToEdit = null;

    $('#add-reader-button').click(() => {
        if (readerToEdit) {
            editReader(readerToEdit)
        } else {
            addNew();
        }
    });

    function editReader(readerToEdit) {

        const firstName = $('#modal-readers-firstName').val();
        const lastName = $('#modal-readers-lastName').val();
        const libraryCard = $('#modal-readers-libraryCard').val();
        const address = $('#modal-readers-address').val();
        const email = $('#modal-readers-email').val();
        const phone = $('#modal-readers-phone').val();

        fetch(`/api/library/readers/${readerToEdit}`, {
            method: 'PATCH',
            body: JSON.stringify({
                firstName: firstName,
                lastName: lastName,
                libraryCard: libraryCard,
                address: address,
                email: email,
                phone: phone
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

        const firstName = $('#modal-readers-firstName').val();
        const lastName = $('#modal-readers-lastName').val();
        const libraryCard = $('#modal-readers-libraryCard').val();
        const address = $('#modal-readers-address').val();
        const email = $('#modal-readers-email').val();
        const phone = $('#modal-readers-phone').val();

        fetch(`/api/library/readers/`, {
            method: 'POST',
            body: JSON.stringify({
                firstName: firstName,
                lastName: lastName,
                libraryCard: libraryCard,
                address: address,
                email: email,
                phone: phone
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
        $('#modal-readers-firstName').val('');
        $('#modal-readers-lastName').val('');
        $('#modal-readers-libraryCard').val('');
        $('#modal-readers-address').val('');
        $('#modal-readers-email').val('');
        $('#modal-readers-phone').val('');
    }

    $('.delete-icon').click(function () {
        let confirm = window.confirm("Are you sure you want to delete this reader?");
        if (!confirm) {
            return false;
        }
        const readerId = this.parentElement.id;
        fetch(`/api/library/readers/${readerId}`, {
            method: 'DELETE'
        }).then(_response => location.reload());
    });

    $('.edit-icon').click(function () {
        readerToEdit = this.parentElement.id;
        const row = this.parentElement.parentElement.parentElement;
        const firstName = row.children[1].innerText;
        const lastName = row.children[2].innerText;
        const libraryCard = row.children[3].innerText;
        const address = row.children[4].innerText;
        const email = row.children[5].innerText;
        const phone = row.children[6].innerText;

        $('#modal-readers-firstName').val(firstName);
        $('#modal-readers-lastName').val(lastName);
        $('#modal-readers-libraryCard').val(libraryCard);
        $('#modal-readers-address').val(address);
        $('#modal-readers-email').val(email);
        $('#modal-readers-phone').val(phone);

    });

    $('#add-reader-main-button').click(() => {
        clearModal();
        readerToEdit = null
    });
});