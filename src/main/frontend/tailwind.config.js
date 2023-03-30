/** @type {import('tailwindcss').Config} */
module.exports = {
  content: ["./public/**/*.{html,ts,tsx}",
            "./src/**/*.{html,ts,tsx}"],
  theme: {
    extend: {},
    fontFamily: {
      "logo": ['"Work Sans"', 'sans-serif'],
      "title": ['Montserrat', 'sans-serif'],
    }
  },
  plugins: [],
}
