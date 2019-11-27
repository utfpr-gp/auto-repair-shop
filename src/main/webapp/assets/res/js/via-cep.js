$(document).ready(() => {
  $('#cep').blur(function() {
    const cep = this.value

    const callback = {
      onSuccess: data => {
        setTimeout(() => {
          $('#state').val(data.uf)
          $('#city').val(data.localidade)
          $('#street').val(data.logradouro)
          closeModalLoading()
        }, 500)
      },
      onError: error => {
        alert('Ops! Esse CEP é inexistente.')
      }
    }

    searchCep(cep, callback)
    openModalLoading()
  })
})

const openModalLoading = () => $('body').append(modalLoading)

const closeModalLoading = () => $('#modal-loading').remove()

const modalLoading = `
  <div id="modal-loading">
    <i class="fa fa-spinner fa-spin"></i>
  </div>
`

const searchCep = (cep, callback) => {
  const url = `https://viacep.com.br/ws/${cep}/json/`

  $.ajax({
    url,
    method: 'GET',
    dataType: 'json',
    success: response => {
      callback.onSuccess(response)
    },
    error: error => {
      callback.onError(error)
    }
  })
}
