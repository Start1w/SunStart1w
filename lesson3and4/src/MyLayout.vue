<script setup>

</script>

<template>
  <div class="layout">
    <header>
      <slot name="header">Header</slot>
    </header>
    <main>
      <slot>Main</slot>
    </main>
    <footer>
      <slot name="footer">Footer</slot>
    </footer>
  </div>
</template>

<style scoped>
.layout {
  display: flex;
  flex-direction: column;
  min-height: 100vh;
}
header, footer {
  background-color: #f8f9fa;
  padding: 20px;
}
main {
  flex: 1;
  padding: 20px;
}
</style>

