document.write("<table>");



for (let i = 2; i < 10; i++) {
  document.write("<tr>");
  for (let j = 1; j < 10; j++) {
    document.write("<td>");
    document.write(i + ' x ' + j + ' = ' + i * j + '\t');
    document.write("</td>");
  }
  document.write("</tr>");
}
document.write("</table>");
