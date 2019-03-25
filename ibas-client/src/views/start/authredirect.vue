<script>
  export default {
    name: 'AuthRedirect',
    created () {
      const query = window.location.search.slice(1)
      window.opener.location.href = window.location.origin + '/start?' + query
      window.close()
    }
  }
</script>
