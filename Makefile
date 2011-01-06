
all: demo.pdf presentation.pdf

presentation.pdf: presentation.tex
	pdflatex presentation.tex

demo.pdf: demo.tex
	pdflatex demo.tex
	bibtex demo
	pdflatex demo.tex
	pdflatex demo.tex

clean:
	rm -f demo.pdf presentation.pdf
