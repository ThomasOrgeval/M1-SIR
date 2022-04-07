import {Pipe, PipeTransform} from '@angular/core';

@Pipe({
  name: 'localTime'
})
export class LocalTimePipe implements PipeTransform {

  transform(value: string, format: LocalTimeFormat | string): string {
    let temp = new Date(value.substring(0, value.length - 5))
    let language = navigator.language

    if (format === LocalTimeFormat.SHORT) {
      let date = new Date(temp).toLocaleDateString(language)
      let time = new Date(temp).toLocaleTimeString(language)
      return `${date}, ${time}`
    } else if (format === LocalTimeFormat.SHORT_DATE)
      return new Date(temp).toLocaleDateString(language)
    else if (format === LocalTimeFormat.SHORT_TIME)
      return new Date(temp).toLocaleTimeString(language)
    else if (format === LocalTimeFormat.FULL)
      return new Date(temp).toString()
    else {
      console.error(`Do not have logic to format utc date, format:${format}`)
      return new Date(temp).toString()
    }
  }

}

export enum LocalTimeFormat {
  FULL = 'full',
  SHORT = 'short',
  SHORT_DATE = 'short_date',
  SHORT_TIME = 'short_time',
}
