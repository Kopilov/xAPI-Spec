#!/bin/bash
java po2md.Po2md <xAPI_ru.po >xAPI_ru.md
sed -i 's/ --/ –/g' xAPI_ru.md
sed -i 's/-- /– /g' xAPI_ru.md
#ln xAPI.md xAPI_en.md
##A=$(md5sum xAPI_en.md)
#rm xAPI_en.md
#java po2md.Po2md checkorig <xAPI_ru.po >xAPI_en.md
#B=$(md5sum xAPI_en.md)
#if [[ $A != $B ]]; then
#	echo "English output do not concur with original!"
#else
#	rm xAPI_en.md
#fi
