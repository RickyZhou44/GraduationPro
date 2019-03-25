// translate router.meta.title, be used in breadcrumb sidebar tagsview
export function generateTitle (title: string): string {
  const hasKey = this.$te('route.' + title)

  if (hasKey) {
    // $t :this method from vue-i18n, inject in @/lang/home.js
    return this.$t('route.' + title)
  }
  return title
}
