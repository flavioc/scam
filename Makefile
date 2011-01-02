
all:
	pdflatex demo.tex
	bibtex demo
	pdflatex demo.tex
	pdflatex demo.tex
