import type { Config } from "tailwindcss";
const {nextui} = require("@nextui-org/react");

const config: Config = {
  content: [
    "./src/pages/**/*.{js,ts,jsx,tsx,mdx}",
    "./src/components/**/*.{js,ts,jsx,tsx,mdx}",
    "./src/app/**/*.{js,ts,jsx,tsx,mdx}",
  ],
  theme: {
    extend: {
      colors: {
        'blue-marguerite': {
          '50': '#f7f6fc',
          '100': '#efeff8',
          '200': '#e3e1f3',
          '300': '#cdc8ea',
          '400': '#b2a8dd',
          '500': '#9685cd',
          '600': '#836abe',
          '700': '#7157aa',
          '800': '#5f488f',
          '900': '#4f3d75',
          '950': '#32264f',
        },
        'color-ui': {
          'crema_black': '#242422',
          'crema_white': '#FDFBF6',
        },
      },
      backgroundImage: {
        "gradient-radial": "radial-gradient(var(--tw-gradient-stops))",
        "gradient-conic":
          "conic-gradient(from 180deg at 50% 50%, var(--tw-gradient-stops))",
      },
    },
  },
  plugins: [],
};
export default config;
