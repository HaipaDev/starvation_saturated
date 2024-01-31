import os

prefix=""
with open("prefix.txt","r") as prefix_file:
    prefix=prefix_file.read()
    prefix_file.close()

template=""
with open("template.txt","r") as template_file:
    template=template_file.read()
    template_file.close()

peaceful_text=template.replace(" T(vanilla is 10)","")

easy_text=template.replace("peacefulHungerValues","easyHungerValues").replace("Peaceful","Easy").replace("PEACEFUL","EASY").replace(" T(vanilla is 10)"," (vanilla is 10)")
normal_text=template.replace("peacefulHungerValues","normalHungerValues").replace("Peaceful","Normal").replace("PEACEFUL","NORMAL").replace(" T(vanilla is 10)"," (vanilla is 1)")
hard_text=template.replace("peacefulHungerValues","hardHungerValues").replace("Peaceful","Hard").replace("PEACEFUL","HARD").replace(" T(vanilla is 10)"," (vanilla is 0)")

final_text = (
    "{\n"+
    f"{prefix}\n{peaceful_text}\n\n\n{easy_text}\n\n\n{normal_text}\n\n\n{hard_text}"+
    "}"
).replace(",}","\n}")
with open("en_us.json","w") as final_file:
    final_file.write(final_text)
    final_file.close()